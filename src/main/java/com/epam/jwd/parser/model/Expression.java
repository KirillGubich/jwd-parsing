package com.epam.jwd.parser.model;

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
        return " " + getValue();
    }
}
