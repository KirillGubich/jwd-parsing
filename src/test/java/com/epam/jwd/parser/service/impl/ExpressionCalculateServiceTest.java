package com.epam.jwd.parser.service.impl;

import com.epam.jwd.parser.service.CalculateService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionCalculateServiceTest {

    @Test
    public void calculate() {
        String expression = "(((~6&9|(3&4))^3)>1)<2";
        CalculateService calculateService = new ExpressionCalculateService(expression);
        assertEquals(20, calculateService.calculate());
    }
}