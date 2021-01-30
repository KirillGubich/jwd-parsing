package com.epam.jwd.parser.handling;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseHandler implements TextHandler {

    private TextHandler nextHandler;

    public void setNextHandler(TextHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public TextHandler getNextHandler() {
        return nextHandler;
    }

    public static List<String> parseText(String textToParse, String regexp) {
        List<String> components = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(textToParse);
        while (matcher.find()) {
            components.add(matcher.group());
        }
        return components;
    }
}
