package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandWichController {
    @GetMapping("")
    public String list(){
        return "index";
    }
//    @PostMapping("/sandwich")
//    public ModelAndView getSandwich(@RequestParam("choose") String[] choose, Model model){
//        if(choose[0]==null){
//            System.out.println("Please choose");
//        }
//        return new ModelAndView("sandwich","choose",choose);
//
//    }
@PostMapping("/sandwich")
    public String getSandwich(@RequestParam("choose") String[] choose,Model model){
        model.addAttribute("choose",choose);
        return "sandwich";
}
}

