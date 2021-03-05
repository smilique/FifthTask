package com.epam.training.tasks.fifth.logic;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private final static String COMBINED_EXPRESSION = "8 2 7 4 2 2 ^ / + * -";
    private final static String COMBINED_EXPECTED = "8.0";
    private final static String PLUS_EXPRESSION = "7 2 +";
    private final static String PLUS_EXPECTED = "9.0";
    private final static String MINUS_EXPRESSION = "8 2 -";
    private final static String MINUS_EXPECTED = "-6.0";
    private final static String MULTIPLY_EXPRESSION = "3 7 *";
    private final static String MULTIPLY_EXPECTED = "21.0";
    private final static String DIVIDE_EXPRESSION = "2 1 /";
    private final static String DIVIDE_EXPECTED = "0.5";
    private final static String EXPONENT_EXPRESSION = "3 2 ^";
    private final static String EXPONENT_EXPECTED = "8.0";


    @Test
    public void testCalculateShouldReturnCorrectResultWhenPlusExpressionSubmitted() {
        //given
        Calculator calculator = new Calculator(PLUS_EXPRESSION);
        //when
        String actual = calculator.calculate();
        //then
        Assert.assertEquals(PLUS_EXPECTED, actual);
    }

    @Test
    public void testCalculateShouldReturnCorrectResultWhenMinusExpressionSubmitted() {
        //given
        Calculator calculator = new Calculator(MINUS_EXPRESSION);
        //when
        String actual = calculator.calculate();
        //then
        Assert.assertEquals(MINUS_EXPECTED, actual);
    }

    @Test
    public void testCalculateShouldReturnCorrectResultWhenMultiplyExpressionSubmitted() {
        //given
        Calculator calculator = new Calculator(MULTIPLY_EXPRESSION);
        //when
        String actual = calculator.calculate();
        //then
        Assert.assertEquals(MULTIPLY_EXPECTED, actual);
    }

    @Test
    public void testCalculateShouldReturnCorrectResultWhenDivideExpressionSubmitted() {
        //given
        Calculator calculator = new Calculator(DIVIDE_EXPRESSION);
        //when
        String actual = calculator.calculate();
        //then
        Assert.assertEquals(DIVIDE_EXPECTED, actual);
    }

    @Test
    public void testCalculateShouldReturnCorrectResultWhenExponentExpressionSubmitted() {
        //given
        Calculator calculator = new Calculator(EXPONENT_EXPRESSION);
        //when
        String actual = calculator.calculate();
        //then
        Assert.assertEquals(EXPONENT_EXPECTED, actual);
    }

    @Test
    public void testCalculateShouldReturnCorrectResultWhenCombinedExpressionSubmitted() {
        //given
        Calculator calculator = new Calculator(COMBINED_EXPRESSION);
        //when
        String actual = calculator.calculate();
        //then
        Assert.assertEquals(COMBINED_EXPECTED, actual);
    }


}