package com.epam.jwd.parser.notation;

import com.epam.jwd.parser.notation.impl.ReversePolishNotationConverter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReversePolishNotationConverterTest {

    private static ExpressionConverter converter;

    @BeforeClass
    public static void beforeClass() {
        converter = ReversePolishNotationConverter.getInstance();
    }

    @Test
    public void transformExpression() {
        String expression = "~6&9|(3&4)";
        String actual = converter.convertExpression(expression);
        assertEquals("6~9&34&|", actual);
    }
}