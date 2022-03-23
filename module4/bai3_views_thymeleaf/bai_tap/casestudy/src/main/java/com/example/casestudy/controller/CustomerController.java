package com.example.casestudy.controller;

import com.example.casestudy.model.CustomerType;
import com.example.casestudy.service.CustomerService;
import com.example.casestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public ModelAndView getList(Model model){
        List<CustomerType>customerTypes=customerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypes);
        return new ModelAndView("list","customers",customerService.findAll());
    }
}
