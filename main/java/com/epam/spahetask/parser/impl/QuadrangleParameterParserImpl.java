package com.epam.spahetask.parser.impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.parser.QuadrangleParameterParser;
import com.epam.spahetask.validator.QuadrangleParameterValidator;

import java.util.LinkedList;
import java.util.List;

public class QuadrangleParameterParserImpl implements QuadrangleParameterParser {
    public final String POINT_DELIMITER = "\\s+";
    public final String VALUE_DELIMITER = ",";

    @Override
    public List<CustomPoint> parseParameters(String parameterString) throws ShapeException {
        if (parameterString == null || !QuadrangleParameterValidator.isValid(parameterString)) {
            throw new ShapeException("Invalid parameter string\"" + parameterString + "\"");
        }

        List<CustomPoint> result = new LinkedList<>();
        PointFactory factory = new PointFactory();

        for (String stringPoint : parameterString.strip().split(POINT_DELIMITER)) {
            String[] values = stringPoint.split(VALUE_DELIMITER);
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);
            result.add(factory.createPoint(x, y));
        }

        return result;
    }
}
