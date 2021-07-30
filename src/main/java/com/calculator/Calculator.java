package com.calculator;

import com.calculator.exception.CalculatorException;

import java.util.Scanner;

public class Calculator {

    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String MULTIPLICATION = "*";
    static final String DIVISION = "/";
    static final String ROOT = "sqrt";
    static final String EXPONENTIAL = "^";

    Scanner scanner = new Scanner(System.in);
    int flag;
    double firstNumber;
    double secondNumber ;
    String operation;

    public static double readNumber(Scanner localScanner) throws CalculatorException {
        System.out.println("You should enter a number");
        double result;
        validateNumber(localScanner);
        result = localScanner.nextDouble();
        return result;
    }

    public static boolean validateNumber(Scanner localScanner) throws CalculatorException {
        if(!localScanner.hasNextDouble()){
            localScanner.next();
            throw new CalculatorException("You should enter a number");}
        return true;
    }

    public static int readFlag(Scanner localScanner) {
        System.out.println("Enter 1 to begin, any other leads to closure of the App");
        String flagString = localScanner.next();
        int flag;
        try {
            flag = Integer.parseInt(flagString);
        } catch (NumberFormatException exception) {
            return 0;
        }
        if(flag == 1){
            return 1;
        }
        return 0;
    }

    public static String readOperation(Scanner scanner){
        System.out.println("Enter operation: *, /, +, -, ^, sqrt");
        String operationString = scanner.next();
        return operationString;
    }

    public static double countResult(double localFirstNumber, double localSecondNumber, String operation) throws CalculatorException {
        double result = 0;
        switch (operation){
            case PLUS:
                result = localFirstNumber + localSecondNumber;
                break;
            case MINUS:
                result = localFirstNumber - localSecondNumber;
                break;
            case DIVISION:
                if(localSecondNumber == 0){
                    throw new CalculatorException( "Division by zero");
                }
                result = localFirstNumber/localSecondNumber;
                break;
            case MULTIPLICATION:
                result = localFirstNumber*localSecondNumber;
                break;
            case EXPONENTIAL:
                result = Math.pow(localFirstNumber,localSecondNumber);
                break;
            case ROOT:
                if(localFirstNumber < 0){
                    throw new CalculatorException( "You should enter a positive number");
                }
                result = Math.sqrt(localFirstNumber);
                break;
        }
        return result;
    }

    public static boolean validateOperation(String operationString) throws CalculatorException {
        if(operationString.isEmpty()) {
            throw new CalculatorException("You should enter an operation");
        }
        if( !operationString.equals(MINUS) && !operationString.equals(PLUS) &&
                !operationString.equals(MULTIPLICATION) && !operationString.equals(DIVISION) &&
                !operationString.equals(ROOT) && !operationString.equals(EXPONENTIAL)){

            throw new CalculatorException("You should enter an existing operation");
        }
        return true;
    }

}