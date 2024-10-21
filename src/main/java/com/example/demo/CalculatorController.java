package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculator(
            @RequestParam(name = "num1", required = false, defaultValue = "3") float num1,
            @RequestParam(name = "num2", required = false, defaultValue = "2") float num2,
            @RequestParam(name = "op", required = false, defaultValue = "+") String op,
            Model view) {
        float result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                break;
        }
        view.addAttribute("num1", num1);
        view.addAttribute("num2", num2);
        view.addAttribute("op", op);
        view.addAttribute("result", result);
        return "calculator";
    }

}
