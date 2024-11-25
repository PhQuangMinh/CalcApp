package com.example.calc;

import java.util.List;
import java.util.Stack;

public class CalcPostFix {
    private double calculate(double x, double y, char operator) {
        return switch (operator) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            case ':' -> x / y;
            case '^' -> Math.pow(x, y);
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals(":") || token.equals("^");
    }

    public double calcPostFix(List<String> tokens) {
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                double y = stack.pop();
                double x = stack.pop();
                double result = calculate(x, y, token.charAt(0));
                stack.push(result);
            } else {
                double t = Double.parseDouble(token);
                stack.push(t);
            }
        }
        return stack.pop();
    }
}
