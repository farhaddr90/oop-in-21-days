package com.dorri.week1.page171.bad;

public class Operator {
    public double calculate(String operation, double a, double b) {
        switch (operation) {
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "/" -> {
                if (b == 0)
                    throw new ArithmeticException("Division by zero");
                return a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operation");
        }
    }
}
