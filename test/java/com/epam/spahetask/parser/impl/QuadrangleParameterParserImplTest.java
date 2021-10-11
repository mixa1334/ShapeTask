package com.epam.spahetask.parser.impl;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.parser.QuadrangleParameterParser;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleParameterParserImplTest {

    @Test
    public void testParseParametersPositiveOutcome() throws ShapeException {
        QuadrangleParameterParser parser = new QuadrangleParameterParserImpl();
        String input = "   1,2    -5,2  2,3  9,-6  ";  //," 1,2    -5,2  2,3  9,-6  -5,4");
        List<CustomPoint> expected = List.of(new CustomPoint(1,2), new CustomPoint(-5,2),
                                                new CustomPoint(2,3), new CustomPoint(9,-6));

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