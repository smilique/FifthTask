package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {

    private final String firstWord = "First";
    private final String secondWord = "Second";
    private final String firstExpression = "[3 4 +]";
    private final String secondExpression = "[4 2 /]";
    private final String wordData = firstWord + " " + secondWord;
    private final String expressionData = firstExpression + " " + secondExpression;


    @Test
    public void testSentenceParserShouldParseWordLexemesWhenParsingWordSentence() {
        //given
        Composite expected = new Composite();
        expected.add(Lexeme.word(firstWord));
        expected.add(Lexeme.word(secondWord));
        SentenceParser parser = new SentenceParser();
        //when
        Component actual = parser.parse(wordData);
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSentenceParserShouldParseExpressionLexemesWhenParsingExpressionSentence() {
        //given
        Composite expected = new Composite();
        expected.add(Lexeme.expression(firstExpression));
        expected.add(Lexeme.expression(secondExpression));
        SentenceParser parser = new SentenceParser();
        //when
        Component actual = parser.parse(expressionData);
        //then
        Assert.assertEquals(expected,actual);
    }

}