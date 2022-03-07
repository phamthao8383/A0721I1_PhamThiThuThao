package com.example.blog_manager.controller;

import com.example.blog_manager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("")
    public ModelAndView getCustomerList() {
        return new ModelAndView("list", "blogs", blogService.findAll());
    }
}
