package com.epam.training.tasks.fifth.logic;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private final static Logger LOGGER = Logger.getLogger(Calculator.class);
    //2 3 ^ 5 / 7 * 10 + 3 -
    private final ArrayList<AbstractMathExpression> listExpression;

    public Calculator(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String element : expression.split("\\p{Blank}+")) {
            if (element.isEmpty()) {
                continue;
            }

            LOGGER.debug(element + " element found");
            char temp = element.charAt(0);
            switch (temp) {
                case '+' : {
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                }
                case '-' : {
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                }
                case '*' : {
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                }
                case '/' : {
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                }
                case '^' : {
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

    public String calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        Number result = context.popValue();

        return result.toString();
    }
}
