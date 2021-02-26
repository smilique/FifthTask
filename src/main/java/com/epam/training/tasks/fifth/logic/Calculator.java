package com.epam.training.tasks.fifth.logic;

import com.epam.training.tasks.fifth.entities.Lexeme;
import org.apache.log4j.Logger;

import java.util.Stack;

import static com.epam.training.tasks.fifth.entities.LexemeType.EXPRESSION;

public class Calculator {
    //2 ^ 3 / 5 * 7 + 10 - 3
    //is
    //2 3 ^ 5 / 7 * 10 + 3 -
    //8 5 / 7 * 10 + 3 -
    //1.6 7 * 10 + 3 -
    //11.2 10 + 3 -
    //21.2 3 -
    //18.2

    private final static Logger LOGGER = Logger.getLogger(Calculator.class);
    private final static String SPLITTER = " ";
    private final static String DIVISION = "/";
    private final static String MULTIPLICATION = "*";
    private final static String SUMMATION = "+";
    private final static String SUBTRACTION = "-";
    private final static String EXPONENTIATION = "^";

    public Lexeme calculate(Lexeme lexeme) {

        String[] data = lexeme.get().split(SPLITTER);
        Stack<String> elements = new Stack<>();

        for (int i = data.length-1; i > 1; i--) {
            elements.add(data[i]);
        }

        while (elements.size() != 1) {
            double firstNumber = Double.parseDouble(elements.pop());
            double secondNumber = Double.parseDouble(elements.pop());
            String operand = elements.pop();
            elements.add(proceed(firstNumber, secondNumber, operand));
        }
        return new Lexeme(elements.pop(),EXPRESSION);
    }

    private String proceed(double firstNumber, double secondNumber, String operand) {
        switch (operand) {
            case DIVISION: {
                return Double.toString(firstNumber / secondNumber);
            }
            case MULTIPLICATION: {
                return Double.toString(firstNumber * secondNumber);
            }
            case SUMMATION: {
                return Double.toString(firstNumber + secondNumber);
            }
            case SUBTRACTION: {
                return Double.toString(firstNumber - secondNumber);
            }
            case EXPONENTIATION: {
                double result = Math.pow(firstNumber, secondNumber);
                return Double.toString(result);
            }
            default: {
                //IllegalOperandException
            }
        }
    }
}
