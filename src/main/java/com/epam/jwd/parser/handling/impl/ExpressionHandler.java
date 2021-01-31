package com.epam.jwd.parser.handling.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.exception.UnknownTextComponentException;
import com.epam.jwd.parser.factory.impl.TextComponentFactory;
import com.epam.jwd.parser.handling.BaseHandler;
import com.epam.jwd.parser.model.ComponentType;

import java.util.regex.Pattern;

public class ExpressionHandler extends BaseHandler {

    public static final String EXPRESSION_REGEXP = "[\\p{Digit}&|^><()~+/*-]++";
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
    public TextComponent handle(String textForProcessing) throws UnknownTextComponentException {
        if (Pattern.matches(EXPRESSION_REGEXP, textForProcessing)) {
            return TextComponentFactory.getInstance().create(ComponentType.EXPRESSION, textForProcessing);
        }
        return getNextHandler() != null ? getNextHandler().handle(textForProcessing) : null;
    }
}
