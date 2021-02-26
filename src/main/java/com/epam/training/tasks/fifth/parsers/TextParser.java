package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import org.apache.log4j.Logger;

import java.util.Arrays;


public class TextParser extends AbstractParser {

    private final static Logger LOGGER = Logger.getLogger(TextParser.class);
    private final static String PARAGRAPH_SPLITTER = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    public Component parse(String inputText) {

        String[] paragraphs = inputText.split(PARAGRAPH_SPLITTER);

        Composite text = new Composite();

        Arrays.stream(paragraphs).forEach(paragraph -> {
            LOGGER.info("Paragraph found!");
            Component component = getSuccessor().parse(paragraph);
            text.add(component);
        });
        return text;
    }
}
