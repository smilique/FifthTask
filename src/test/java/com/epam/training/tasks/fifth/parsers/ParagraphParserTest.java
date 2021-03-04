package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    private final String firstSentence = "First sentence";
    private final String secondSentence = " Second Sentence";
    private final String sentences = firstSentence + "." + secondSentence;

    @Test
    public void testParagraphParserTest() {
        //given
        Composite firstParagraph = new Composite();
        firstParagraph.add(Lexeme.word("First"));
        firstParagraph.add(Lexeme.word("sentence."));

        Composite secondParagraph = new Composite();
        secondParagraph.add(Lexeme.word("Second"));
        secondParagraph.add(Lexeme.word("Sentence!"));

        Composite expected = new Composite();
        expected.add(firstParagraph);
        expected.add(secondParagraph);

        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        when(sentenceParser.parse(firstSentence)).thenReturn(firstParagraph);
        when(sentenceParser.parse(secondSentence)).thenReturn(secondParagraph);

        ParagraphParser parser = new ParagraphParser(sentenceParser);
        //when
        Component actual = parser.parse(sentences);

        //then
        Assert.assertEquals(expected,actual);

    }

}