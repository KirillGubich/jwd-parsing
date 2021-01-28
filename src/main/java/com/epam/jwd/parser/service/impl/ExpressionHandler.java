package com.epam.jwd.parser.service.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.factory.impl.TextComponentFactory;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.service.BaseHandler;

import java.util.regex.Pattern;

public class ExpressionHandler extends BaseHandler {

    public static final String EXPRESSION_REGEXP = "[\\p{Digit}\\p{Punct}]++";
    private static ExpressionHandler instance;

    private ExpressionHandler() {
    }

    public static ExpressionHandler getInstance() {
        if (instance == null) {
            instance = new ExpressionHandler();
        }
        return instance;
    }

    @Override
    public TextComponent handle(String textForProcessing) {
        if (Pattern.matches(EXPRESSION_REGEXP, textForProcessing)) {
            return TextComponentFactory.getInstance().create(ComponentType.EXPRESSION, textForProcessing);
        }

        return getNextHandler() != null ? getNextHandler().handle(textForProcessing) : null;
    }
}
