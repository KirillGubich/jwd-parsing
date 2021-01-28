package com.epam.jwd.parser.factory.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.exception.UnknownTextComponentException;
import com.epam.jwd.parser.factory.ContainerFactory;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.model.Paragraph;
import com.epam.jwd.parser.model.Sentence;
import com.epam.jwd.parser.model.Text;

public class TextContainerFactory implements ContainerFactory {

    private static TextContainerFactory instance;

    private TextContainerFactory() {
    }

    public static TextContainerFactory getInstance() {
        if (instance == null) {
            instance = new TextContainerFactory();
        }
        return instance;
    }

    @Override
    public TextComponent create(ComponentType componentType) throws UnknownTextComponentException {
        TextComponent textComponent;

        switch (componentType) {
            case TEXT:
                textComponent = new Text();
                break;
            case PARAGRAPH:
                textComponent = new Paragraph();
                break;
            case SENTENCE:
                textComponent = new Sentence();
                break;
            default:
                throw new UnknownTextComponentException("Incorrect text component type");
        }

        return textComponent;
    }
}
