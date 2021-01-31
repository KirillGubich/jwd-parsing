package com.epam.jwd.parser.service.impl;

import com.epam.jwd.parser.service.EditingService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextEditingServiceTest {

    private static EditingService editingService;

    @BeforeClass
    public static void beforeClass() {
        editingService = TextEditingService.getInstance();
    }

    @Test
    public void sortParagraphsByNumberOfSentences() {
        String text = "\tHello, World! This text will be sorted.\tHere is the second paragraph.";
        String actual = editingService.sortParagraphsByNumberOfSentences(text).buildText();
        assertEquals("\t Here is the second paragraph.\n\t Hello, World! This text will be sorted.\n", actual);
    }

    @Test
    public void sortSentencesByLexemeLength() {
        String text = "\tSort all words. Try to do it correct.";
        String actual = editingService.sortLexemesByLength(text).buildText();
        assertEquals("\t all Sort words. to do it Try correct.\n", actual);
    }
}