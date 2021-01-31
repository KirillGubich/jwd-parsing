package com.epam.jwd.parser.interpreter.impl;

import com.epam.jwd.parser.interpreter.ExpressionContext;
import com.epam.jwd.parser.interpreter.MathExpression;

public class TerminalExpressionBitwiseShiftLeft implements MathExpression {

    @Override
    public void interpret(ExpressionContext context) {
        Integer countOfShifts = context.popValue();
        context.pushValue(context.popValue() << countOfShifts);
    }
}
