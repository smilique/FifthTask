package com.epam.training.tasks.fifth.logic;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TextLogicTest {

    private final String firstLexeme ="First sm";
    private final String fourthLexeme = "Fourths mid";
    private final String sixthLexeme = "Sixth mid";
    private final String seventhLexeme = "Seventh long";
    private final String eightsLexeme = "Eights long";
    private final String ninthLexeme = "Ninth long";

    private final Component firstSentence = new Composite();
    private final Component secondSentence = new Composite();
    private final Component thirdSentence = new Composite();
    private final Component firstParagraph = new Composite();
    private final Component secondParagraph = new Composite();
    private final Component text = new Composite();

    private final TextLogic logic = new TextLogic();

    @Before
    public void before() {

        firstSentence.add(Lexeme.word(firstLexeme));
        secondSentence.add(Lexeme.word(fourthLexeme));
        secondSentence.add(Lexeme.word(sixthLexeme));
        thirdSentence.add(Lexeme.word(seventhLexeme));
        thirdSentence.add(Lexeme.word(eightsLexeme));
        thirdSentence.add(Lexeme.word(ninthLexeme));

        firstParagraph.add(thirdSentence);
        firstParagraph.add(firstSentence);
        secondParagraph.add(secondSentence);

        text.add(firstParagraph);
        text.add(secondParagraph);
    }

    @Test
    public void sortByParagraph() {
        //given
        Component expected = new Composite();
        expected.add(secondParagraph);
        expected.add(firstParagraph);
        //when
        Composite actual = logic.sortByParagraph((Composite)text);
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sortBySentence() {
        //given
        Component expected = new Composite();
        expected.add(firstSentence);
        expected.add(thirdSentence);
        //when
        Component actual = logic.sortBySentence((Composite) firstParagraph);
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sortByLexeme() {
        //given
        Component expected = new Composite();
        expected.add(Lexeme.word(ninthLexeme));
        expected.add(Lexeme.word(eightsLexeme));
        expected.add(Lexeme.word(seventhLexeme));
        //when
        Component actual = logic.sortByLexeme((Composite) thirdSentence);
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculate() {
        //given
        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.calculate()).thenReturn("14.0");
        Lexeme expressionLexeme = Lexeme.expression("[8 2 7 4 + * -]");
        Lexeme expected = Lexeme.expression("14.0");
        //when
        Lexeme actual = logic.calculate(expressionLexeme);
        //then
        Assert.assertEquals(expected, actual);
    }
}