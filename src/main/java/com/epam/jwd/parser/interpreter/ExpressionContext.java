package com.epam.jwd.parser.interpreter;

public interface ExpressionContext {

    Integer popValue();

    void pushValue(Integer value);
}
