package com.epam.training.tasks.fifth.logic;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextLogicTest {

    private final String first ="First";
    private final String second = "Second";
    private final String third = "Third";
    private final String fourth = "Fourths";
    private final String fifth = "Fifth";
    private final String sixth = "Sixth";
    private final String seventh = "Seventh";
    private final String eights = "Eights";
    private final String ninth = "Ninth";

    private final TextLogic logic = new TextLogic();
    private final Component firstSentence = new Composite();
    private final Component secondSentence = new Composite();
    private final Component thirdSentence = new Composite();
    private final Component firstParagraph = new Composite();
    private final Component secondParagraph = new Composite();
    private final Component text = new Composite();

    @Before
    public void before() {

        firstSentence.add(Lexeme.word(first));
        firstSentence.add(Lexeme.word(second));
        firstSentence.add(Lexeme.word(third));
        secondSentence.add(Lexeme.word(fourth));
        secondSentence.add(Lexeme.word(fifth));
        secondSentence.add(Lexeme.word(sixth));
        thirdSentence.add(Lexeme.word(seventh));
        thirdSentence.add(Lexeme.word(eights));
        thirdSentence.add(Lexeme.word(ninth));

        firstParagraph.add(thirdSentence); //length = 18
        firstParagraph.add(firstSentence); //length = 16
        secondParagraph.add(secondSentence); //length = 17

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

        //then
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
        expected.add(Lexeme.word(ninth));
        expected.add(Lexeme.word(eights));
        expected.add(Lexeme.word(seventh));
        //when
        Component actual = logic.sortByLexeme((Composite) thirdSentence);
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculate() {
        //given
        //when
        //then
    }
}