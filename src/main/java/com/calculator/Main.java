package com.calculator;

import com.calculator.exception.CalculatorException;

public class Main {
    private static void initialization(Calculator localCalculator) throws CalculatorException {
        localCalculator.operation = Calculator.readOperation(localCalculator.scanner);
        Calculator.validateOperation(localCalculator.operation);
        localCalculator.firstNumber = Calculator.readNumber(localCalculator.scanner);
        if(!localCalculator.operation.equals(Calculator.ROOT)){
            localCalculator.secondNumber = Calculator.readNumber(localCalculator.scanner);
        }
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        while(true) {
            calculator.flag = calculator.readFlag(calculator.scanner);
            if (calculator.flag == 1) {
                try{
                    initialization(calculator);
                    System.out.println("Result "+ Calculator.countResult(calculator.firstNumber, calculator.secondNumber, calculator.operation));
                } catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("App closes ");
                break;
            }
        }
    }
}
