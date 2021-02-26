package com.epam.training.tasks.fifth.entities;

public class Lexeme implements Component{

    private LexemeType type;
    private String content;

    public Lexeme() {

    }

    public Lexeme(String content, LexemeType type) {
        this.content = content;
        this.type = type;
    }

    public String get() {
        return content;
    }

    public LexemeType getType() {
        return type;
    }



}
