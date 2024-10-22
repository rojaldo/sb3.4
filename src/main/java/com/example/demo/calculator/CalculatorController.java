package com.example.demo.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.Valid;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(@Valid CalculatorDto calculatorDto, Model view) {

        float result = calculatorService.calculate(calculatorDto.getNum1(), calculatorDto.getNum2(), calculatorDto.getOp());

        view.addAttribute("num1", calculatorDto.getNum1());
        view.addAttribute("num2", calculatorDto.getNum2());
        view.addAttribute("op", calculatorDto.getOp());
        view.addAttribute("result", result);
        return "calculator";
    }

}
