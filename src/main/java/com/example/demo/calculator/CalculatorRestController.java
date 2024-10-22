package com.example.demo.calculator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class CalculatorRestController {

    @Autowired
    CalculatorService CalculatorService;

    @GetMapping("calculator")
    public ResponseEntity<ICalculatorResponse> getMethodName(@Valid CalculatorDto calculatorDto) {
        if(calculatorDto.getEval() != null){
            CalculatorService.processExpression(calculatorDto.getEval());
            if(CalculatorService.isValid()){
                calculatorDto.setNum1(CalculatorService.getNum1());
                calculatorDto.setNum2(CalculatorService.getNum2());
                calculatorDto.setOp(CalculatorService.getOp());
                calculatorDto.setResult(CalculatorService.getResult());
                return ResponseEntity.ok(calculatorDto);
            }else {
                return ResponseEntity.badRequest().body(CalculatorErrorDto.builder()
                    .message("Invalid expression")
                    .details("The expression provided was: " + calculatorDto.getEval())
                    .build());                
            }

        }else{
            float result = CalculatorService.calculate(calculatorDto.getNum1(), calculatorDto.getNum2(), calculatorDto.getOp());
            calculatorDto.setResult(result);
            return ResponseEntity.ok(calculatorDto);
        }
        
    }
    
    
}
