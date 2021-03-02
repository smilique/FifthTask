package com.epam.training.tasks.fifth.logic;

import org.apache.log4j.Logger;

public class TerminalExpressionMultiply extends AbstractMathExpression {

    private final static Logger LOGGER = Logger.getLogger(TerminalExpressionMultiply.class);

    @Override
    public void interpret(Context context) {
        double firstNumber = context.popValue();
        double secondNumber = context.popValue();
        double result = firstNumber * secondNumber;

        LOGGER.debug(firstNumber + " * " + secondNumber + " = " + result);

        context.pushValue(result);
    }
}
