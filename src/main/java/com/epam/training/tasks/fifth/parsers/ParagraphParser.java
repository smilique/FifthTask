package com.epam.training.tasks.fifth.parsers;

import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser{

    private final static String SENTENCE_SPLITTER = "([.!?])"; //incorrect

    //Pattern pattern = Pattern.compile(SENTENCE_SPLITTER);
    public ParagraphParser(Parser successor) {
        super(successor);
    }

    public String getSplitter() {

        return SENTENCE_SPLITTER;
    }

}
