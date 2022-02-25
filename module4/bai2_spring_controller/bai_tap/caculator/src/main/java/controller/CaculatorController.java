package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @GetMapping("")
    public String getCaculator() {
        return "index";
    }

    @PostMapping("/index")
    public ModelAndView caculator(@RequestParam("input1") int input1, @RequestParam("input2") int input2, @RequestParam("choose") String choose, Model model) {
        model.addAttribute("input1", input1);
        model.addAttribute("input2", input2);

        float result = choose(input1, input2, choose);
        model.addAttribute("choose", choose);
        return new ModelAndView("index", "result", result);

    }

    private float choose(int input1, int input2, String choose) {
        float result = 0;

        switch (choose) {
            case "Addition(+)": {
                result = input1 + input2;
                break;
            }
            case "Subtraction(-)": {
                result = input1 - input2;
                break;
            }
            case "Multiplication(*)": {
                result = input1 * input2;
                break;
            }
            case "Division(/)": {
                result = input1 / input2;
                break;
            }
        }

        return result;
    }
}
