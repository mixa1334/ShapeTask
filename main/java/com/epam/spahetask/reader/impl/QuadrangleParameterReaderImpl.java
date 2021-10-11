package com.epam.spahetask.reader.impl;

import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.reader.QuadrangleParameterReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuadrangleParameterReaderImpl implements QuadrangleParameterReader {
    final static Logger logger = LogManager.getLogger();

    @Override
    public List<String> read(String filePath) throws ShapeException {
        File file = new File(filePath);
        if(!file.exists() || file.isDirectory()){
            String message = "Invalid path "+ filePath;
            logger.log(Level.INFO, message);
            throw new ShapeException(message);
        }

        try(Stream<String> lines = Files.lines(file.toPath())){
            List<String> result = lines
                    .collect(Collectors.toList());
            logger.log(Level.INFO, "Parameters from file \""+filePath+"\": "+result);
            return result;
        } catch (IOException e) {
            String message = "Invalid path "+ filePath;
            logger.log(Level.INFO, message);
            throw new ShapeException(message, e);
        }
    }
}
