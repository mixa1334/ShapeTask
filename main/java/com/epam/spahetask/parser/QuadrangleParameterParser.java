package com.epam.spahetask.parser;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.exception.ShapeException;

import java.util.List;

public interface QuadrangleParameterParser {
    List<CustomPoint> parseParameters(String parameterString) throws ShapeException;
}
