package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class ParagraphParser extends AbstractParser{
    private final static Logger LOGGER = Logger.getLogger(ParagraphParser.class);
    private final static String SENTENCE_SPLITTER = "([.!?])|([.{3}])";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    public Component parse(String inputText) {

        LOGGER.info("Getting Sentences from: " + inputText);
        String[] sentences = inputText.split(SENTENCE_SPLITTER);

        Composite text = new Composite();

        Arrays.stream(sentences).forEach(sentence -> {

            LOGGER.info("Sentence [" + sentence + "] found!");

            //LOGGER.debug("Successor: " + getSuccessor().parse("Second Sentence!"));

            Component component = getSuccessor().parse(sentence);
            text.add(component);

            LOGGER.debug(component);
            LOGGER.debug(text);

        });


        return text;
    }
}
