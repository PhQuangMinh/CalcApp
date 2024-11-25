package com.example.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertCalculation {
    private int precedence(char c) {
        return switch (c) {
            case '^' -> 3;
            case ':', '*' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    private boolean isOperand(char c) {
        return Character.isDigit(c) || c == '.';
    }

    private boolean isRightAssociative(char c) {
        return c == '^';
    }

    public List<String> infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (isOperand(c)) {
                numberBuffer.append(c);
            } else {
                if (!numberBuffer.isEmpty()) {
                    result.add(numberBuffer.toString());
                    numberBuffer.setLength(0);
                }

                while (!stack.isEmpty() && (precedence(c) < precedence(stack.peek()) ||
                        (precedence(c) == precedence(stack.peek()) && !isRightAssociative(c)))) {
                    result.add(String.valueOf(stack.pop()));
                }
                stack.push(c);
            }
        }
        if (!numberBuffer.isEmpty()) {
            result.add(numberBuffer.toString());
        }
        while (!stack.isEmpty()) {
            result.add(String.valueOf(stack.pop()));
        }

        return result;
    }
}
