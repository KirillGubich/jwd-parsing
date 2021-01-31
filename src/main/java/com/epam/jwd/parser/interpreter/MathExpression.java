package com.epam.jwd.parser.interpreter;

@FunctionalInterface
public interface MathExpression {

    void interpret(ExpressionContext context);
}
