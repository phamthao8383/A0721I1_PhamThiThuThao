package com.example.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin/home")
public class AdminController {
    @GetMapping()
    public ModelAndView GetHomeAdmin(){
        return new ModelAndView("admin/admin");
    }
    @GetMapping("/category")
    public ModelAndView GetCategoryAdmin(){
        return new ModelAndView("admin/category");
    }
    @GetMapping("/product")
    public ModelAndView GetProductAdmin(){
        return new ModelAndView("admin/product");
    }

}
