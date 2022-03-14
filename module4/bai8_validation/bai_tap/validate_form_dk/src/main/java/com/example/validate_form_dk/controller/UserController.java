package com.example.validate_form_dk.controller;

import com.example.validate_form_dk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ModelAndView getUserList(){
        return new ModelAndView("index","users",userService.findAll());
    }
}
