package com.epam.training.tasks.fifth;

import com.epam.training.tasks.fifth.entities.Component;
import com.epam.training.tasks.fifth.entities.Composite;
import com.epam.training.tasks.fifth.parsers.Parser;
import org.apache.log4j.Logger;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Director {

    private final static Logger LOGGER = Logger.getLogger(Director.class);

    public Component create(Path filename) {
        ChainBuilder builder = new ChainBuilder();
        Parser parser = builder.build();
        String data = null;
        try {
            List<String> lines = Files.readAllLines(filename);
            data = lines.toString();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            //throw new
        }
        return parser.parse(data);
    }


}
