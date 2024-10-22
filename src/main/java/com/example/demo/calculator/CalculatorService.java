package com.example.demo.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.Getter;

enum CalculatorState {
    INIT,
    FIRST_NUMBER,
    SECOND_NUMBER,
    RESULT,
    ERROR
}

@Service
public class CalculatorService {

    private CalculatorState currentState = CalculatorState.INIT;

    @Getter
    private int num1 = 0;

    @Getter
    private int num2 = 0;

    private char op = ' ';

    @Getter
    private float result = 0;

    @Getter
    private ArrayList<String> history = new ArrayList<String>();

    public String getOp() {
        return String.valueOf(op);
    }

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
        history.add(num1 + " " + op + " " + num2 + " = " + result);
        return result;
    }

    void processExpression(String eval) {
        this.resetCalculator();
        // take each character and determine if it is a number or not
        for (int i = 0; i < eval.length(); i++) {
            char c = eval.charAt(i);
            if (Character.isDigit(c)) {
                // if it is a digit, keep going until we find an operator
                this.processNumber(Character.getNumericValue(c));
            } else {
                // if it is an operator, keep going until we find a digit
                this.processSymbol(c);
            }
        }
    }

    private void processNumber(int number) {
        // take each character and determine if it is a number or not
        switch (this.currentState) {
            case INIT:
                this.num1 = number;
                this.currentState = CalculatorState.FIRST_NUMBER;
                break;
            case FIRST_NUMBER:
                this.num1 = this.num1 * 10 + number;
                break;
            case SECOND_NUMBER:
                this.num2 = this.num2 * 10 + number;
                break;
            case RESULT:
                this.currentState = CalculatorState.ERROR;
                break;
            case ERROR:
                break;
            default:
                break;
        }
    }

    private void processSymbol(char symbol) {
        // take each character and determine if it is a number or not
        switch (this.currentState) {
            case INIT:
                this.currentState = CalculatorState.ERROR;
                break;
            case FIRST_NUMBER:
                if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
                    this.op = symbol;
                    this.currentState = CalculatorState.SECOND_NUMBER;
                } else {
                    this.currentState = CalculatorState.ERROR;
                }
                break;
            case SECOND_NUMBER:
                if (symbol == '=') {
                    this.result = this.calculate(this.num1, this.num2, String.valueOf(this.op));
                    this.currentState = CalculatorState.RESULT;
                } else {
                    this.currentState = CalculatorState.ERROR;
                }
                break;
            case RESULT:
                this.currentState = CalculatorState.ERROR;
                break;
            case ERROR:
                break;
            default:
                break;
        }

    }

    private void resetCalculator() {
        this.currentState = CalculatorState.INIT;
        this.num1 = 0;
        this.num2 = 0;
        this.op = ' ';
        this.result = 0;
    }

    public boolean isValid() {
        return this.currentState == CalculatorState.RESULT;
    }

}
