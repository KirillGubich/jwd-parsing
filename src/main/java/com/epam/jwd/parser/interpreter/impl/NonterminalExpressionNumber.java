package com.epam.jwd.parser.interpreter.impl;

import com.epam.jwd.parser.interpreter.ExpressionContext;
import com.epam.jwd.parser.interpreter.MathExpression;

public class NonterminalExpressionNumber implements MathExpression {

    private final int number;

    public NonterminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(ExpressionContext context) {
        context.pushValue(number);
    }
}
