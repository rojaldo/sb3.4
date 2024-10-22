package com.example.demo.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    float calculate(float num1, float num2, String op) {
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
        }
        return result;
    }
}
