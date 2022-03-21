package fresher.Team3.Controllers;

import java.io.IOException;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fresher.Team3.DTO.ResgisterDTO;
import fresher.Team3.Enities.RolesEnity;
import fresher.Team3.Enities.UsersEnity;
import fresher.Team3.Repository.RoleRepository;
import fresher.Team3.Repository.UserRepository;
import fresher.Team3.Services.UserService;

import fresher.Team3.Utils.GooglePojo;
import fresher.Team3.Utils.GoogleUtils;

import validation.RePassword;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender emailSender;


    @GetMapping("/login")
    public String getLogin() {

        return "Login";
    }

    @GetMapping("/registry")
    public String getRegistry(Model model) {
        model.addAttribute("resgisterDTO", new ResgisterDTO());
        return "dangki";
    }

    @PostMapping("/registry")
    public String postRegistry(Model model, @Valid ResgisterDTO resgisterDTO, BindingResult bindingResult,
                               HttpServletRequest request) {
        RePassword rePassword = new RePassword();
        rePassword.validate(resgisterDTO, bindingResult);
        UsersEnity usersEnity = userRepository.findByEmail(resgisterDTO.getEmail());
        /*
         * rePassword.emailerr(resgisterDTO, bindingResult);
         */
        if (bindingResult.hasErrors() || usersEnity != null) {
            model.addAttribute("items", bindingResult.getAllErrors());
            /* System.out.println(bindingResult.getFieldError().getField()); */
            if (usersEnity != null) {
                model.addAttribute("Error", "email ton tai");
            }
            return "dangki";
        }

        Random generator = new Random();
        int ecode = generator.nextInt(100);

        HttpSession session = request.getSession();

        resgisterDTO.seteCode(String.valueOf(ecode));
        session.setAttribute("resgisterDTO", resgisterDTO);

        return "redirect:/Checkout";
    }

    @GetMapping("/Checkout")
    public String getCheckout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        ResgisterDTO resgisterDTO = (ResgisterDTO) session.getAttribute("resgisterDTO");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(resgisterDTO.getEmail());
        message.setSubject("ShopCart");
        message.setText(resgisterDTO.geteCode());
        this.emailSender.send(message);
        model.addAttribute("resgisterDTO2", new ResgisterDTO());
        System.out.println(resgisterDTO);
        return "Checkout";
    }

    @PostMapping("/Checkout")
    public String PostCheckout(HttpServletRequest request, Model model, ResgisterDTO resgisterDTO2) {

        HttpSession session = request.getSession();
        ResgisterDTO resgisterDTO = (ResgisterDTO) session.getAttribute("resgisterDTO");
        if (!resgisterDTO2.geteCode().equals(resgisterDTO.geteCode())) {
            model.addAttribute("resgisterDTO2", new ResgisterDTO());
            return "Checkout";
        } else {
            UsersEnity user = new UsersEnity();
            RolesEnity role = roleRepository.findByName("user");
            user.setUsername(resgisterDTO.getUsername());
            user.setPassword(new BCryptPasswordEncoder(4).encode(resgisterDTO.getPassword()));
            user.setEmail(resgisterDTO.getEmail());
            user.setName(resgisterDTO.getName());
            user.getRolesEnities().add(role);
            userService.saveUser(user);
            session.setAttribute("resgisterDTO", null);

        }
        return "redirect:/login";
    }

    /*
     * gmail ==================================================================
     */
    @Autowired
    private GoogleUtils googleUtils;

    @RequestMapping("/login-google")
    public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            return "redirect:/login?login_error=true";
        }
        String accessToken = googleUtils.getToken(code);
        GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
        UserDetails userDetail = googleUtils.buildUser(googlePojo);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/index";
    }

}
