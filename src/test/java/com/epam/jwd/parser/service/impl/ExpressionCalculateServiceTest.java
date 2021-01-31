package com.epam.jwd.parser.interpreter.impl;

import com.epam.jwd.parser.interpreter.ExpressionClient;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionCalculateClientTest {

    @Test
    public void calculate() {
        String expression = "6 ~ 9 & 3 4 & | 3 ^ 1 < 1 > ";
        ExpressionClient expressionClient = new ExpressionCalculateClient(expression);
        assertEquals(10, expressionClient.calculate());
    }
}