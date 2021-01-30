package com.epam.jwd.parser.handling.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.factory.impl.TextContainerFactory;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.model.Paragraph;
import com.epam.jwd.parser.handling.BaseHandler;

import java.util.List;

public class SentenceHandler extends BaseHandler {

    private static SentenceHandler instance;
    public static final String SENTENCE_REGEXP = "[\\p{Upper}\\d]+.*?[.?!]";

    private SentenceHandler() {
    }

    public static SentenceHandler getInstance() {
        if (instance == null) {
            instance = new SentenceHandler();
        }
        return instance;
    }

    @Override
    public TextComponent handle(String textForProcessing) {
        Paragraph paragraph = (Paragraph) TextContainerFactory.getInstance().create(ComponentType.PARAGRAPH);
        List<String> sentences = parseText(textForProcessing, SENTENCE_REGEXP);

        if (getNextHandler() != null) {
            for (String sentence : sentences) {
                paragraph.addComponent(getNextHandler().handle(sentence));
            }
        }
        return paragraph;
    }
}
