package com.epam.training.tasks.fifth.logic;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private final static Logger LOGGER = Logger.getLogger(Calculator.class);
    private final ArrayList<AbstractMathExpression> listExpression;
    private final static char PLUS = '+';
    private final static char MINUS = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';
    private final static char EXPONENT = '^';

    public Calculator(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String element : expression.split("\\p{Blank}+")) {
            if (!element.isEmpty()) {
                LOGGER.debug(element + " element found");
                char temp = element.charAt(0);
                switch (temp) {
                    case PLUS: {
                        listExpression.add(new TerminalExpressionPlus());
                        break;
                    }
                    case MINUS: {
                        listExpression.add(new TerminalExpressionMinus());
                        break;
                    }
                    case MULTIPLY: {
                        listExpression.add(new TerminalExpressionMultiply());
                        break;
                    }
                    case DIVIDE: {
                        listExpression.add(new TerminalExpressionDivide());
                        break;
                    }
                    case EXPONENT: {
                        listExpression.add(new TerminalExpressionExponent());
                        break;
                    }
                    default:
                        Scanner scanner = new Scanner(element);
                        if (scanner.hasNextDouble()) {
                            listExpression.add(
                                    new NonTerminalExpressionNumber(scanner.nextDouble()));
                        }
                }
            }
        }
    }

    public String calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        Number result = context.popValue();

        return result.toString();
    }
}
