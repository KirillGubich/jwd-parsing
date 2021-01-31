package com.epam.jwd.parser.model;

import com.epam.jwd.parser.service.CalculateService;
import com.epam.jwd.parser.service.impl.ExpressionCalculateService;

public class Expression extends Lexeme {

    public Expression(String value) {
        super(value);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String buildText() {
        CalculateService calculateService = new ExpressionCalculateService(getValue());
        return " " + calculateService.calculate();
    }
}
