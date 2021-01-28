package com.epam.jwd.parser.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TextHandlerTest {

    private static TextHandler textHandler;

    @BeforeClass
    public static void beforeClass() {
        textHandler = TextHandler.getInstance();
    }

    @Test
    public void handle() {
    }

    @Test
    public void paragraphParser() {
        String textToParse = "\tHello, World!\n\tThis is next paragraph.\n";
        List<String> paragraphs = textHandler.parseText(textToParse, TextHandler.PARAGRAPH_REGEXP);
        assertEquals(2, paragraphs.size());
        assertEquals("\tHello, World!\n", paragraphs.get(0));
        assertEquals("\tThis is next paragraph.\n", paragraphs.get(1));
    }
}