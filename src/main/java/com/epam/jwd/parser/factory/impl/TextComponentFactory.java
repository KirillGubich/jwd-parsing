package com.epam.jwd.parser.factory.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.exception.UnknownTextComponentException;
import com.epam.jwd.parser.factory.ComponentFactory;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.model.Expression;
import com.epam.jwd.parser.model.Word;

public class TextComponentFactory implements ComponentFactory {

    private static TextComponentFactory instance;

    private TextComponentFactory() {
    }

    public static TextComponentFactory getInstance() {
        if (instance == null) {
            instance = new TextComponentFactory();
        }
        return instance;
    }

    @Override
    public TextComponent create(ComponentType componentType, String value) throws UnknownTextComponentException {
        TextComponent textComponent;

        switch (componentType) {
            case WORD:
                textComponent = new Word(value);
                break;
            case EXPRESSION:
                textComponent = new Expression(value);
                break;
            default:
                throw new UnknownTextComponentException("Incorrect text component type");
        }

        return textComponent;
    }
}
