package com.epam.training.tasks.fifth.parsers;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import org.apache.log4j.Logger;

import java.util.Arrays;

abstract class AbstractParser implements Parser{

    private final static Logger LOGGER = Logger.getLogger(AbstractParser.class);

    private Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected abstract String getSplitter();

    protected Parser getSuccessor() {
        return successor;
    }

    @Override
    public Component parse(String inputText) {

        String currentSplitter = getSplitter();
        LOGGER.debug(inputText);
        String[] textData = inputText.split(currentSplitter);
        LOGGER.debug(textData);
        Composite entity = new Composite();

        Arrays.stream(textData).forEach(element -> {
            LOGGER.debug("Current successor: " + getSuccessor());
            LOGGER.debug("Element [" + element + "] found");
            Component component = getSuccessor().parse(element);
            entity.add(component);
        });

        return entity;
    }





    public AbstractParser() {

    }

}
