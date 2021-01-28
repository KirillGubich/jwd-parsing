package com.epam.jwd.parser.model;

import com.epam.jwd.parser.composite.TextComponent;

public class Expression implements TextComponent {

    private final String value;

    public Expression(String value) {
        this.value = value;
    }

    @Override
    public String buildText() {
        return " " + value;
    }
}
