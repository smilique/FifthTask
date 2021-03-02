package com.epam.training.tasks.fifth.logic;

public class NonTerminalExpressionNumber extends AbstractMathExpression {
    private double number;
    public NonTerminalExpressionNumber(double number) {
        this.number = number;
    }
    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
