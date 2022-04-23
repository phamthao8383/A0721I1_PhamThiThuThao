package com.example.casestudy.controller;

import com.example.casestudy.model.RentType;
import com.example.casestudy.model.Service;
import com.example.casestudy.model.ServiceType;
import com.example.casestudy.service.RentTypeService;
import com.example.casestudy.service.IServiceService;
import com.example.casestudy.service.ServiceTypeService;
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
@RequestMapping("/member/service")
public class ServiceController {
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private IServiceService iServiceService;
    @Autowired
     private RentTypeService rentTypeService;
    @GetMapping()
    public ModelAndView getServiceList(@PageableDefault(size = 2) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<com.example.casestudy.model.Service> services;
        if (search.isPresent()) {
            services = iServiceService.findAllByNameContaining(search.get(), pageable);
        } else {
            services = iServiceService.findAll(pageable);
        }
        return new ModelAndView("service/list", "services", services);
    }
    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model) {
        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        List<RentType> rentTypes=rentTypeService.findAll();
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("rentTypes", rentTypes);
        return new ModelAndView("service/create", "services", new com.example.casestudy.model.Service());
    }
    @PostMapping("/create")
    public String saveService(@Valid @ModelAttribute("services") Service service,BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
//          IServiceService.saveService(service);
//        redirectAttributes.addFlashAttribute("message", "success");
//        return new ModelAndView("redirect:/member/service");
        if(bindingResult.hasErrors()){
            List<ServiceType> serviceTypes = serviceTypeService.findAll();
            List<RentType> rentTypes=rentTypeService.findAll();
            model.addAttribute("serviceTypes", serviceTypes);
            model.addAttribute("rentTypes", rentTypes);
//         return new ModelAndView("service/create","services",new Service());
            return "service/create";
        }else {
            iServiceService.saveService(service);
            redirectAttributes.addFlashAttribute("message", "success");
            return "redirect:/member/service";
        }


    }

}
