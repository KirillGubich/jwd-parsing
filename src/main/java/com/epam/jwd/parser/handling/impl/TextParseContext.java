package com.epam.jwd.parser.handling.impl;

import com.epam.jwd.parser.handling.ParseContext;
import com.epam.jwd.parser.handling.TextHandler;

public class TextParseContext implements ParseContext {

    private static TextParseContext instance;

    private TextParseContext() {
    }

    public static TextParseContext getInstance() {
        if (instance == null) {
            instance = new TextParseContext();
        }
        return instance;
    }

    @Override
    public TextHandler getFullTextHandler() {
        ExpressionHandler expressionHandler = ExpressionHandler.getInstance();
        expressionHandler.setNextHandler(WordHandler.getInstance());
        LexemeHandler lexemeHandler = LexemeHandler.getInstance();
        lexemeHandler.setNextHandler(expressionHandler);
        SentenceHandler sentenceHandler = SentenceHandler.getInstance();
        sentenceHandler.setNextHandler(lexemeHandler);
        ParagraphHandler paragraphHandler = ParagraphHandler.getInstance();
        paragraphHandler.setNextHandler(sentenceHandler);
        return paragraphHandler;
    }
}
