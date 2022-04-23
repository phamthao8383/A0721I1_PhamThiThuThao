package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.CustomerType;
import com.example.casestudy.service.CustomerService;
import com.example.casestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping()
    public ModelAndView getCustomerList( @PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findAllByNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        return new ModelAndView("customer/list", "customers", customers);
    }
    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model) {
        List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        return new ModelAndView("customer/create", "customers", new Customer());
    }
    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customers") Customer customer, RedirectAttributes redirectAttributes){
            customerService.saveCustomer(customer);
            redirectAttributes.addFlashAttribute("message", "success");
            return new ModelAndView("redirect:/admin/customer");
    }
    @GetMapping("edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id,Model model){
        List<CustomerType> customerTypes= (List<CustomerType>) customerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypes);
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer != null) {
            return new ModelAndView("customer/edit", "customer", customer);
        } else {
            return new ModelAndView("/error");
        }
    }
    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer( @ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return new ModelAndView("redirect:/admin/customer");
    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id,Model model){
        List<CustomerType> customerTypes= (List<CustomerType>) customerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypes);
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer != null) {
            return new ModelAndView("customer/delete", "customer", customer);
        } else {
            return new ModelAndView("/error");
        }
    }
    @PostMapping("/delete-customer")
    public ModelAndView DeleteCustomer(@ModelAttribute ("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return  new ModelAndView("redirect:/admin/customer");
    }
}
