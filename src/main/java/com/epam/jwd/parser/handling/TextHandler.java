package com.epam.jwd.parser.handling;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.exception.UnknownTextComponentException;

public interface TextHandler {

    TextComponent handle(String textForProcessing) throws UnknownTextComponentException;
}
