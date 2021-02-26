package com.epam.training.tasks.fifth;

import com.epam.training.tasks.fifth.parsers.ParagraphParser;
import com.epam.training.tasks.fifth.parsers.Parser;
import com.epam.training.tasks.fifth.parsers.SentenceParser;
import com.epam.training.tasks.fifth.parsers.TextParser;

public class ChainBuilder {

    public Parser build() {
        return new TextParser(new ParagraphParser(new SentenceParser()));

    }
}
