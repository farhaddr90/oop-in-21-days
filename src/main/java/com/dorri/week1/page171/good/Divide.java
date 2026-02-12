package com.dorri.week1.page171.good;

public class Divide extends Operation {
    @Override
    protected double calculate(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("Divide by zero");
        return a / b;
    }
}
