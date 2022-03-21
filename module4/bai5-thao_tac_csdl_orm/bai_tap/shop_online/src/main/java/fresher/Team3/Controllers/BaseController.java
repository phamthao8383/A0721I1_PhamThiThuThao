package fresher.Team3.Controllers;


import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

import fresher.Team3.Enities.UsersEnity;
import fresher.Team3.Repository.UserRepository;


public class BaseController {
    @Autowired
    UserRepository userRepository;

    @ModelAttribute("userLogined")
    public UserDetails getUserLogined() {
        Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userLogined != null && userLogined instanceof UserDetails)
            return (UserDetails) userLogined;
        return null;
    }

    @ModelAttribute("userLoginedIsEnity")
    public UsersEnity userLoginedIsEnity() {
        if (getUserLogined() != null)
            return userRepository.findByEmail(getUserLogined().getUsername());
        return null;
    }


    public Date dateNow() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }


}
