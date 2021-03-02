package com.epam.training.tasks.fifth.logic;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private final String expression = "8 2 7 4 + * -";
    private final String expected = "14.0";

    @Test
    public void testCalculate() {
        //given
        Calculator calculator = new Calculator(expression);
        //when
        String actual = calculator.calculate();
        //then
        Assert.assertEquals(expected, actual);
    }

}