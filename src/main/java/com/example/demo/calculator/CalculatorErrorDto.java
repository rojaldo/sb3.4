package com.example.demo.calculator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalculatorErrorDto implements ICalculatorResponse {
    private String message;
    private String details;
}
