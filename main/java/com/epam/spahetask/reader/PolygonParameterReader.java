package com.epam.spahetask.reader;

import com.epam.spahetask.exception.ShapeException;

import java.util.List;

public interface PolygonParameterReader {
    List<String> read(String filePath) throws ShapeException;
}
