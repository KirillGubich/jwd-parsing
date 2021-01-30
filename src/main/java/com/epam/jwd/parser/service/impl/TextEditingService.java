package com.epam.jwd.parser.service.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.handling.ParseContext;
import com.epam.jwd.parser.handling.TextHandler;
import com.epam.jwd.parser.handling.impl.TextParseContext;
import com.epam.jwd.parser.model.Lexeme;
import com.epam.jwd.parser.model.Paragraph;
import com.epam.jwd.parser.model.Sentence;
import com.epam.jwd.parser.model.Text;
import com.epam.jwd.parser.service.EditingService;

import java.util.Comparator;
import java.util.List;

public class TextEditingService implements EditingService {

    private static TextEditingService instance;

    private TextEditingService() {
    }

    public static TextEditingService getInstance() {
        if (instance == null) {
            instance = new TextEditingService();
        }
        return instance;
    }

    @Override
    public TextComponent sortParagraphsByNumberOfSentences(String editableText) {
        Text text = parseText(editableText);
        List<TextComponent> paragraphs = text.getComponents();
        paragraphs.sort(Comparator.comparingInt(o -> ((Paragraph) o).getComponents().size()));
        return text;
    }

    @Override
    public TextComponent sortLexemesByLength(String editableText) {
        Text text = parseText(editableText);
        List<TextComponent> paragraphs = text.getComponents();
        sortLexemesByLengthInParagraphs(paragraphs);
        return text;
    }

    private void sortLexemesByLengthInParagraphs(List<TextComponent> paragraphs) {
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = ((Paragraph) paragraph).getComponents();
            for (TextComponent sentence : sentences) {
                ((Sentence) sentence).getComponents()
                        .sort(Comparator.comparingInt(o -> ((Lexeme) o).getValue().length()));
            }
        }
    }

    private Text parseText(String text) {
        ParseContext parseContext = TextParseContext.getInstance();
        TextHandler textHandler = parseContext.getFullTextHandler();
        return (Text) textHandler.handle(text);
    }
}