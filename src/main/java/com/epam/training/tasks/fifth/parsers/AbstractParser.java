package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import org.apache.log4j.Logger;

import java.util.Arrays;

abstract class AbstractParser implements Parser{

    private final static Logger LOGGER = Logger.getLogger(AbstractParser.class);
    private Parser successor;

    protected abstract String getSplitter();

    public AbstractParser(){

    }

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    @Override
    public Component parse(String inputText) {

        String currentSplitter = getSplitter();
        String[] textData = inputText.split(currentSplitter);
        Composite entity = new Composite();

        LOGGER.debug("Splitting: " + inputText + "\nWith: " + currentSplitter);

        Arrays.stream(textData).forEach(element -> {
            LOGGER.debug("Element [" + element + "] found");
            Component component = getSuccessor().parse(element);
            entity.add(component);
        });

        return entity;
    }



}
