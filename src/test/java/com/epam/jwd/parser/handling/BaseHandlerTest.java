package com.epam.jwd.parser.handling;

import com.epam.jwd.parser.handling.impl.LexemeHandler;
import com.epam.jwd.parser.handling.impl.ParagraphHandler;
import com.epam.jwd.parser.handling.impl.SentenceHandler;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BaseHandlerTest {

    @Test
    public void parseParagraphs() {
        String textToParse = "\tHello, World!\n\tThis is next paragraph.";
        List<String> paragraphs = BaseHandler.parseText(textToParse, ParagraphHandler.PARAGRAPH_REGEXP);
        assertEquals(2, paragraphs.size());
        assertEquals("\tHello, World!", paragraphs.get(0));
        assertEquals("\tThis is next paragraph.", paragraphs.get(1));
    }

    @Test
    public void parseSentences() {
        String textToParse = "Hello, World! This is next sentence.";
        List<String> sentences = BaseHandler.parseText(textToParse, SentenceHandler.SENTENCE_REGEXP);
        assertEquals(2, sentences.size());
        assertEquals("Hello, World!", sentences.get(0));
        assertEquals("This is next sentence.", sentences.get(1));
    }

    @Test
    public void parseLexemes() {
        String textToParse = "It has survived – (five) centuries.";
        List<String> lexemes = BaseHandler.parseText(textToParse, LexemeHandler.LEXEME_REGEXP);
        assertEquals(6, lexemes.size());
        assertEquals("It", lexemes.get(0));
        assertEquals("has", lexemes.get(1));
        assertEquals("survived", lexemes.get(2));
        assertEquals("–", lexemes.get(3));
        assertEquals("(five)", lexemes.get(4));
        assertEquals("centuries.", lexemes.get(5));
    }
}