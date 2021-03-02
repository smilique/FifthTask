package com.epam.training.tasks.fifth.logic;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;
import org.apache.log4j.Logger;

import java.util.List;

public class TextLogic {

    private final static Logger LOGGER = Logger.getLogger(TextLogic.class);

    private Composite sortComposite(Composite composite) {

        List<Component> components = composite.get();

        components.sort((first, second) -> {
            List<Component> firstComponent = ((Composite) first).get();
            List<Component> secondComponent = ((Composite) second).get();
            int firstComponentSize = firstComponent.size();
            int secondComponentSize = secondComponent.size();
            LOGGER.debug(firstComponentSize);
            LOGGER.debug(secondComponentSize);
            LOGGER.debug("Difference " + (firstComponentSize - secondComponentSize));

            return firstComponentSize - secondComponentSize;
        });

        Composite result = new Composite();
        for (Component component : components) {
            result.add(component);
        }

        return result;
    }

    public Composite sortByParagraph(Composite text) {
        return sortComposite(text);
    }

    public Composite sortBySentence(Composite paragraph) {
        return sortComposite(paragraph);
    }

    public Composite sortByLexeme(Composite lexemes) {
        List<Component> components = lexemes.get();

        components.sort((first, second) -> {
            String firstLexeme = ((Lexeme) first).get();
            String secondLexeme = ((Lexeme) second).get();
            int firstComponentSize = firstLexeme.length();
            int secondComponentSize = secondLexeme.length();

            return firstComponentSize - secondComponentSize;
        });

        Composite result = new Composite();
        for (Component lexeme : components) {
            result.add(lexeme);
        }

        return result;
    }

    public Lexeme calculate(Component component) {
        String expression = ((Lexeme) component).get();
        Calculator calculator = new Calculator(expression);
        String calculated = calculator.calculate();

        return Lexeme.expression(calculated);
    }
}
