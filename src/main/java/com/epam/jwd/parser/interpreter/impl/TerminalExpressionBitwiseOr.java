package com.epam.jwd.parser.interpreter.impl;

import com.epam.jwd.parser.interpreter.ExpressionContext;
import com.epam.jwd.parser.interpreter.MathExpression;

public class TerminalExpressionBitwiseOr implements MathExpression {

    @Override
    public void interpret(ExpressionContext context) {
        context.pushValue(context.popValue() | context.popValue());
    }
}
