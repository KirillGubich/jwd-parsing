package com.epam.jwd.parser.service.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.factory.impl.TextComponentFactory;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.service.BaseHandler;

public class WordHandler extends BaseHandler {

    private static WordHandler instance;

    private WordHandler() {
    }

    public static WordHandler getInstance() {
        if (instance == null) {
            instance = new WordHandler();
        }
        return instance;
    }

    @Override
    public TextComponent handle(String textForProcessing) {
        return TextComponentFactory.getInstance().create(ComponentType.WORD, textForProcessing);
    }
}
