package com.epam.jwd.parser.interpreter.impl;

import com.epam.jwd.parser.interpreter.ExpressionContext;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionCalculateContext implements ExpressionContext {

    private final Deque<Integer> contextValues = new ArrayDeque<>();

    @Override
    public Integer popValue() {
        return contextValues.pop();
    }

    @Override
    public void pushValue(Integer value) {
        this.contextValues.push(value);
    }
}
