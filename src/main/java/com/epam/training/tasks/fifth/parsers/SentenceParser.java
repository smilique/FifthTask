package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static com.epam.training.tasks.fifth.entities.LexemeType.EXPRESSION;
import static com.epam.training.tasks.fifth.entities.LexemeType.WORD;


public class SentenceParser extends AbstractParser{

    private final static Logger LOGGER = Logger.getLogger(SentenceParser.class);
    private final static String LEXEME_SPLITTER = "\\s";
    private final static String EXPRESSION_START = "[";
    private final static String EXPRESSION_END = "]";

    public SentenceParser(){
    }

    public Component parse(String inputText) {
        String[] lexemes = inputText.split(LEXEME_SPLITTER);

        Composite text = new Composite();

        Arrays.stream(lexemes).forEach(lexeme -> {
            Lexeme component;
            if (lexeme.startsWith(EXPRESSION_START)
                    & lexeme.endsWith(EXPRESSION_END)) {
                LOGGER.info("Expression Lexeme found!");
                //calculate exception here
                component = new Lexeme(lexeme, EXPRESSION);
            } else {
                LOGGER.info("Word Lexeme found!");
                component = new Lexeme(lexeme, WORD);
            }
            text.add(component);
        });

        return text;
    }


}
