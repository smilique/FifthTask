package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceParserTest {

    private final String dataToParse = "First Second";


    @Test
    public void testSentenceParserShouldWork() {
        //given
        Composite expected = new Composite();
        expected.add(Lexeme.word("First"));
        expected.add(Lexeme.word("Second"));
        SentenceParser parser = new SentenceParser();
        //when
        Component actual = parser.parse(dataToParse);
        //then
        Assert.assertEquals(expected,actual);
    }

}