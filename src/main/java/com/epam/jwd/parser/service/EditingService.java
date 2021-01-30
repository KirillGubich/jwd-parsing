package com.epam.jwd.parser.service;

import com.epam.jwd.parser.composite.TextComponent;

public interface EditingService {

    TextComponent sortParagraphsByNumberOfSentences(String editableText);

    TextComponent sortLexemesByLength(String editableText);
}
