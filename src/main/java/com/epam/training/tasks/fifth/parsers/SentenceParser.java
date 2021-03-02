package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SentenceParser extends AbstractParser{

    private final static Logger LOGGER = Logger.getLogger(SentenceParser.class);
    private final static String EXPRESSION_REGEX = "\\[.*?]";
    private final static String WORD_REGEX = "\\S*";
    private final static String LEXEME_REGEX = "(" + EXPRESSION_REGEX + ")|(" + WORD_REGEX + ")";

    public SentenceParser(){
    }

    public Component parse(String inputText) {
        LOGGER.info("Getting Lexemes from: " + inputText);

        Pattern lexemePattern = Pattern.compile(LEXEME_REGEX);
        Matcher lexemeMatcher = lexemePattern.matcher(inputText);
        Composite text = new Composite();

        while (lexemeMatcher.find()) {
            Lexeme component;
            String currentLexeme = lexemeMatcher.group();
            if (!currentLexeme.isEmpty()) {
                Pattern expressionPattern = Pattern.compile(EXPRESSION_REGEX);
                Matcher expressionMatcher = expressionPattern.matcher(currentLexeme);
                if (expressionMatcher.matches()) {
                    LOGGER.info("Expression found: " + currentLexeme);
                    component = Lexeme.expression(currentLexeme);
                } else {
                    LOGGER.debug("Word found: " + currentLexeme);
                    component = Lexeme.word(currentLexeme);
                }
                text.add(component);
            }
        }

        return text;
    }


}
