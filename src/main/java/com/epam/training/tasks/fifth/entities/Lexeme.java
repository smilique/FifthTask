package com.epam.training.tasks.fifth.entities;

import java.util.Objects;

import static com.epam.training.tasks.fifth.entities.LexemeType.EXPRESSION;
import static com.epam.training.tasks.fifth.entities.LexemeType.WORD;

public class Lexeme implements Component{

    private LexemeType type;
    private String content;

    @Override
    public void add(Component component) {

    }

    public Lexeme() {

    }

    private Lexeme(String content, LexemeType type) {
        this.content = content;
        this.type = type;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value,WORD);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value,EXPRESSION);
    }

    public String get() {
        return content;
    }

    public LexemeType getType() {
        return type;
    }

    @Override
    public String toString() {
        return  content;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Lexeme lexeme = (Lexeme) object;
        return type == lexeme.type && Objects.equals(content, lexeme.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, content);
    }
}
