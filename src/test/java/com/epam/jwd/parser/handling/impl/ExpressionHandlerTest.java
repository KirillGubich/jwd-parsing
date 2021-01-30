package com.epam.jwd.parser.handling.impl;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.factory.impl.TextComponentFactory;
import com.epam.jwd.parser.model.ComponentType;
import com.epam.jwd.parser.model.Expression;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionHandlerTest {

    private static ExpressionHandler expressionHandler;

    @BeforeClass
    public static void beforeClass() {
        expressionHandler = ExpressionHandler.getInstance();
    }

    @Test
    public void handle() {
        String firstValue = "~6&9|(3&4)";
        TextComponent firstExp = TextComponentFactory.getInstance().create(ComponentType.EXPRESSION, firstValue);
        String secondValue = "a+b";
        Expression secondExp = (Expression) TextComponentFactory.getInstance().create(ComponentType.EXPRESSION, secondValue);
        assertEquals(firstExp, expressionHandler.handle(firstValue));
        assertNotEquals(secondExp, expressionHandler.handle(secondValue));
    }
}