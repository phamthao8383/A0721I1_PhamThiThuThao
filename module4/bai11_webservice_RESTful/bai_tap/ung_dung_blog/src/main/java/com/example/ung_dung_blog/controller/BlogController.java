package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.impl.BlogServiceImpl;
import com.example.ung_dung_blog.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private CategoryService categoryService;
   @GetMapping("")
    public ModelAndView getBlogList(Model model) {
        List<Category> categories=categoryService.findAll();
        model.addAttribute("categories",categories);
        return new ModelAndView("index","blogs",blogService.findAll());
    }
}