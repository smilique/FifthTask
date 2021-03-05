package com.epam.training.tasks.fifth;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.parsers.Parser;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Director {

    private final static Logger LOGGER = Logger.getLogger(Director.class);

    public Component create(Path filename) throws FileReaderException{
        ChainBuilder builder = new ChainBuilder();
        Parser parser = builder.build();
        String data = null;
        try {
            List<String> lines = Files.readAllLines(filename);
            data = lines.toString();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new FileReaderException(e.getMessage(), e);
        }
        return parser.parse(data);
    }


}
