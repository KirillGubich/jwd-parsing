package com.epam.jwd.parser.notation.impl;

import com.epam.jwd.parser.notation.ExpressionConverter;

import java.util.Stack;

public class ReversePolishNotationConverter implements ExpressionConverter {

    private static ReversePolishNotationConverter instance;

    private ReversePolishNotationConverter() {
    }

    public static ReversePolishNotationConverter getInstance() {
        if (instance == null) {
            instance = new ReversePolishNotationConverter();
        }
        return instance;
    }

    @Override
    public String convertExpression(String expression) {
        StringBuilder transformedExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            if (stack.isEmpty() || getRelativePriority(expression.charAt(i)) > getStackPriority(stack.peek())) {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    transformedExpression.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && getRelativePriority(expression.charAt(i)) <= getStackPriority(stack.peek())) {
                    transformedExpression.append(stack.pop());
                }
                stack.push(expression.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            transformedExpression.append(stack.pop());
        }
        return transformedExpression.toString();
    }

    private int getRelativePriority(char character) {
        switch (character) {
            case '|':
                return 1;
            case '^':
                return 3;
            case '&':
                return 5;
            case '<':
            case '>':
                return 7;
            case '~':
                return 9;
            case '(':
                return 13;
            case ')':
                return 0;
            default:
                return 11;
        }
    }

    private int getStackPriority(char character) {
        switch (character) {
            case '|':
                return 2;
            case '^':
                return 4;
            case '&':
                return 6;
            case '<':
            case '>':
                return 8;
            case '~':
                return 10;
            case '(':
                return 0;
            default:
                return 12;
        }
    }
}
