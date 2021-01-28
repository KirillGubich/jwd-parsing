package com.epam.jwd.parser.service.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.factory.impl.TextContainerFactory;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.model.Text;
import com.epam.jwd.parser.service.BaseHandler;

import java.util.List;

public class ParagraphHandler extends BaseHandler {

    private static ParagraphHandler instance;
    public static final String PARAGRAPH_REGEXP = "\t[\\p{Upper}\\d]+.*?(?=\n|\t|$)";

    private ParagraphHandler() {
    }

    public static ParagraphHandler getInstance() {
        if (instance == null) {
            instance = new ParagraphHandler();
        }
        return instance;
    }

    @Override
    public TextComponent handle(String textForProcessing) {
        Text text = (Text) TextContainerFactory.getInstance().create(ComponentType.TEXT);
        List<String> paragraphs = parseText(textForProcessing, PARAGRAPH_REGEXP);

        if (getNextHandler() != null) {
            for (String paragraph : paragraphs) {
                text.addComponent(getNextHandler().handle(paragraph));
            }
        }
        return text;
    }
}
