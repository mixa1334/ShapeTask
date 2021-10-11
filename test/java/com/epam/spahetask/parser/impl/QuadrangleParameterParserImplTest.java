package com.epam.spahetask.parser.impl;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.parser.QuadrangleParameterParser;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleParameterParserImplTest {

    @Test
    public void testParseParametersPositiveOutcome() throws ShapeException {
        QuadrangleParameterParser parser = new QuadrangleParameterParserImpl();
        String input = "   1,2    -5,2  2,3  9,-6  ";  //," 1,2    -5,2  2,3  9,-6  -5,4");
        List<CustomPoint> expected = List.of(PointFactory.createPoint(1,2),
                                                PointFactory.createPoint(-5,2),
                                                PointFactory.createPoint(2,3),
                                                PointFactory.createPoint(9,-6));

        List<CustomPoint> actual = parser.parseParameters(input);

        assertEquals(actual, expected);
    }

    @Test (expectedExceptions = ShapeException.class)
    public void testParseParametersNegativeOutcome() throws ShapeException {
        QuadrangleParameterParser parser = new QuadrangleParameterParserImpl();
        String input = "   1,2    -5,2  2,3  9,-6  7,999";  //," 1,2    -5,2  2,3  9,-6  -5,4");

        parser.parseParameters(input);
    }
}