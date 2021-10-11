package com.epam.spahetask.reader;

import com.epam.spahetask.exception.ShapeException;

import java.util.List;

public interface QuadrangleParameterReader {
    List<String> read(String filePath) throws ShapeException;
}
