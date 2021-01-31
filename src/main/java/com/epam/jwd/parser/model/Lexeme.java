package com.epam.jwd.parser.model;

import com.epam.jwd.parser.composite.TextComponent;

import java.util.Objects;

public abstract class Lexeme implements TextComponent {

    private final String value;

    public Lexeme(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lexeme lexeme = (Lexeme) o;
        return Objects.equals(value, lexeme.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
