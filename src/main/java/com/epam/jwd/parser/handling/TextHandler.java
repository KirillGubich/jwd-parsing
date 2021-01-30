package com.epam.jwd.parser.handling;

import com.epam.jwd.parser.composite.TextComponent;

public interface TextHandler {

    TextComponent handle(String textForProcessing);
}
