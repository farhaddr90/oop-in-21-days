package com.dorri.week1.page171.good;

import java.util.List;

public class Operator {
    public static double calculate(Operation operation, double a, double b) {
        return operation.calculate(a, b);
    }

    public static void main(String[] args) {
        double a = 10, b = 5;
        List<Operation> operations = List.of(new Add(), new Subtract(), new Multiply(), new Divide());
        for (Operation operation : operations) {
            System.out.println(calculate(operation, a, b));
        }
    }
}
