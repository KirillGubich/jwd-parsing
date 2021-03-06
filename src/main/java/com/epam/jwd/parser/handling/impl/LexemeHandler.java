package com.epam.jwd.parser.handling.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.exception.UnknownTextComponentException;
import com.epam.jwd.parser.factory.impl.TextContainerFactory;
import com.epam.jwd.parser.handling.BaseHandler;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.model.Sentence;

import java.util.List;

public class LexemeHandler extends BaseHandler {

    public static final String LEXEME_REGEXP = "[\\p{Graph}\\–]+?([!?.,]|(?=\\h))";
    private static LexemeHandler instance;

    private LexemeHandler() {
    }

    public static LexemeHandler getInstance() {
        if (instance == null) {
            instance = new LexemeHandler();
        }
        return instance;
    }

    @Override
    public TextComponent handle(String textForProcessing) throws UnknownTextComponentException {
        Sentence sentence = (Sentence) TextContainerFactory.getInstance().create(ComponentType.SENTENCE);
        List<String> lexemes = parseText(textForProcessing, LEXEME_REGEXP);

        if (getNextHandler() != null) {
            for (String lexeme : lexemes) {
                sentence.addComponent(getNextHandler().handle(lexeme));
            }
        }
        return sentence;
    }
}
