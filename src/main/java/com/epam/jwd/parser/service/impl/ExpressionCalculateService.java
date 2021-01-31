package com.epam.jwd.parser.service.impl;

import com.epam.jwd.parser.interpreter.ExpressionContext;
import com.epam.jwd.parser.interpreter.MathExpression;
import com.epam.jwd.parser.interpreter.impl.ExpressionCalculateContext;
import com.epam.jwd.parser.interpreter.impl.NonterminalExpressionNumber;
import com.epam.jwd.parser.interpreter.impl.TerminalExpressionBitwiseAnd;
import com.epam.jwd.parser.interpreter.impl.TerminalExpressionBitwiseNegation;
import com.epam.jwd.parser.interpreter.impl.TerminalExpressionBitwiseOr;
import com.epam.jwd.parser.interpreter.impl.TerminalExpressionBitwiseShiftLeft;
import com.epam.jwd.parser.interpreter.impl.TerminalExpressionBitwiseShiftRight;
import com.epam.jwd.parser.interpreter.impl.TerminalExpressionBitwiseXor;
import com.epam.jwd.parser.notation.impl.ReversePolishNotationConverter;
import com.epam.jwd.parser.service.CalculateService;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpressionCalculateService implements CalculateService {

    private final ArrayList<MathExpression> listExpression;

    public ExpressionCalculateService(String expression) {
        listExpression = new ArrayList<>();
        prepareCalculations(expression);
    }

    private void prepareCalculations(String expression) {
        expression = expression.replace("<<", "<");
        expression = expression.replace(">>", ">");
        String preparedExpression = ReversePolishNotationConverter.getInstance().convertExpression(expression);
        parse(preparedExpression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '|':
                    listExpression.add(new TerminalExpressionBitwiseOr());
                    break;
                case '&':
                    listExpression.add(new TerminalExpressionBitwiseAnd());
                    break;
                case '~':
                    listExpression.add(new TerminalExpressionBitwiseNegation());
                    break;
                case '^':
                    listExpression.add(new TerminalExpressionBitwiseXor());
                    break;
                case '<':
                    listExpression.add(new TerminalExpressionBitwiseShiftLeft());
                    break;
                case '>':
                    listExpression.add(new TerminalExpressionBitwiseShiftRight());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(new NonterminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

    @Override
    public Number calculate() {
        ExpressionContext context = new ExpressionCalculateContext();
        for (MathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
