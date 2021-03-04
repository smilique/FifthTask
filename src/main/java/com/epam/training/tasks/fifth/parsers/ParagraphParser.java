package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;

public class ParagraphParser extends AbstractParser {

    private final static String SENTENCE_SPLITTER = "([.!?])";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public String getSplitter() {
        return SENTENCE_SPLITTER;
    }

    @Override
    public Component parse(String inputText) {
        return super.parse(inputText);
    }
}
