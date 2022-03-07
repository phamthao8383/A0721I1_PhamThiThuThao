package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public ModelAndView getCustomerList(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findAllByNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        return new ModelAndView("list", "customers", customers);
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return new ModelAndView("create", "customer", new Customer());
    }

    @PostMapping("/create")
    public String saveCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<Province> provinces = provinceService.findAll();
            model.addAttribute("provinces", provinces);
          //  model.addAttribute("customer", new Customer());
            return "create";
        } else {
            customerService.saveCustomer(customer);
            redirectAttributes.addFlashAttribute("message", "Create success");
            return "redirect:/";
        }
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        Customer customer = customerService.findCustomerById(id);
        if (customer != null) {
            return new ModelAndView("edit", "customer", customer);
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@Valid @ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id, Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        Customer customer = customerService.findCustomerById(id);
        if (customer != null) {
            return new ModelAndView("delete", "customer", customer);
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-customer")
    public String DeleteCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/";
    }

}

