package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.when;

public class TextParserTest {

    private final String first ="First";
    private final String second = "Second";
    private final String third = "Third";
    private final String fourth = "Fourth";
    private final String fifth = "Fifth";
    private final String sixth = "Sixth";
    private final String seventh = "Seventh";
    private final String eights = "Eights";

    private final String firstInput = first + " " + second + ". " + third + " " + fourth + ".";
    private final String secondInput = fifth + " " + sixth + ". " + seventh + " " + eights + ".";
    private final String paragraphs = firstInput + "\n" + secondInput + "\n";

    @Test
    public void testTextParser() {
        //given
        Component firstSentence = new Composite();
        firstSentence.add(
                Lexeme.word(first));
        firstSentence.add(
                Lexeme.word(second));
        Component secondSentence = new Composite();
        secondSentence.add(
                Lexeme.word(third));
        secondSentence.add(
                Lexeme.word(fourth));
        Component thirdSentence = new Composite();
        thirdSentence.add(
                Lexeme.word(fifth));
        thirdSentence.add(
                Lexeme.word(sixth));
        Component fourthSentence = new Composite();
        fourthSentence.add(
                Lexeme.word(seventh));
        fourthSentence.add(
                Lexeme.word(eights));

        Component firstParagraph = new Composite();
        firstParagraph.add(firstSentence);
        firstParagraph.add(secondSentence);
        Component secondParagraph = new Composite();
        secondParagraph.add(thirdSentence);
        secondParagraph.add(fourthSentence);

        Component expected = new Composite();
        expected.add(firstParagraph);
        expected.add(secondParagraph);
        
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        when(paragraphParser.parse(firstInput)).thenReturn(firstParagraph);
        when(paragraphParser.parse(secondInput)).thenReturn(secondParagraph);

        TextParser parser = new TextParser(paragraphParser);
        //when
        Component actual = parser.parse(paragraphs);
        //then
        Assert.assertEquals(expected,actual);
    }

}