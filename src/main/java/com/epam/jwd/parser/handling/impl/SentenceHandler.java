package com.epam.jwd.parser.handling.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.exception.UnknownTextComponentException;
import com.epam.jwd.parser.factory.impl.TextContainerFactory;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.model.Paragraph;
import com.epam.jwd.parser.handling.BaseHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SentenceHandler extends BaseHandler {

    private static SentenceHandler instance;
    public static final String SENTENCE_REGEXP = "[\\p{Upper}\\d]+.*?[.?!]";
    private static final Logger LOGGER = LogManager.getLogger(SentenceHandler.class);

    private SentenceHandler() {
    }

    public static SentenceHandler getInstance() {
        if (instance == null) {
            instance = new SentenceHandler();
        }
        return instance;
    }

    @Override
    public TextComponent handle(String textForProcessing) throws UnknownTextComponentException {
        Paragraph paragraph = (Paragraph) TextContainerFactory.getInstance().create(ComponentType.PARAGRAPH);
        List<String> sentences = parseText(textForProcessing, SENTENCE_REGEXP);

        if (getNextHandler() != null) {
            for (String sentence : sentences) {
                paragraph.addComponent(getNextHandler().handle(sentence));
            }
            LOGGER.info("Lexemes has been successfully parsed.");
        }
        return paragraph;
    }
}
