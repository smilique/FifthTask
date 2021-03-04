package com.epam.training.tasks.fifth.parsers;

public class TextParser extends AbstractParser {

    private final static String PARAGRAPH_SPLITTER = "\\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSplitter() {
        return PARAGRAPH_SPLITTER;
    }


}
