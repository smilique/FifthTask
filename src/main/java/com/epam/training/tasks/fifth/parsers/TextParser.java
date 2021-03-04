package com.epam.training.tasks.fifth.parsers;

import java.util.regex.Pattern;

public class TextParser extends AbstractParser {

    private final static String PARAGRAPH_SPLITTER = "\n";

    Pattern pattern = Pattern.compile(PARAGRAPH_SPLITTER);
    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSplitter() {
        return PARAGRAPH_SPLITTER;
    }


}
