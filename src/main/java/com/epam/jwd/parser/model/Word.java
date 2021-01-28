package com.epam.jwd.parser.model;

import com.epam.jwd.parser.composite.TextComponent;

import java.util.Objects;

public class Word implements TextComponent {

    private final String value;

    public Word(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public String buildText() {
        return " " + value;
    }
}
