package com.epam.training.tasks.fifth.parsers;

abstract class AbstractParser implements Parser{

    private Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    public AbstractParser() {

    }

}
