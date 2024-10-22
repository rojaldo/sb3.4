package com.example.demo.calculator;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorDto {

    @Min(-1000)
    @Max(1000)
    private float num1;

    @Range(min = -1000, max = 1000)
    private float num2;

    @Pattern(regexp = "[+\\-*/]")
    private String op;

}
