package com.epam.training.tasks.fifth.logic;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.entities.Lexeme;

import java.util.List;

public class TextLogic {

    private Composite sortComposite(Composite composite) {
        List<Component> components = composite.get();

        components.sort((first, second) -> {
            List<Component> firstComponent = ((Composite) first).get();
            List<Component> secondComponent = ((Composite) second).get();
            int firstComponentSize = firstComponent.size();
            int secondComponentSize = secondComponent.size();

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

    public Component calculate(Component component) {
        String expression = ((Lexeme) component).get();
        Calculator calculator = new Calculator(expression);
        String calculated = calculator.calculate();

        return Lexeme.expression(calculated);
    }
}
