package com.example.casestudy.controller;

import com.example.casestudy.DTO.UserDTO;
import com.example.casestudy.model.Role;
import com.example.casestudy.model.User;
import com.example.casestudy.service.RoleService;
import com.example.casestudy.service.UserService;
import com.example.casestudy.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        return new ModelAndView("register","registerUser",new UserDTO());
    }

    @PostMapping("/register")
    public String registerUser(@Validated @ModelAttribute("registerUser") UserDTO registerUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "register";
        }else {
            com.example.casestudy.model.User user = new User();
            user.setUsername(registerUser.getUsername());
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils(registerUser.getPassword()));
            Role roleEntity = roleService.findByName("ROLE_MEMBER");
            Set<Role> listRoles = new HashSet<>();
            listRoles.add(roleEntity);
            user.setRoles(listRoles);
            userService.save(user);
            return "redirect:/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            Cookie cookie = new Cookie("remember-me", "");
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        }
        return "redirect:/index";
    }

}
