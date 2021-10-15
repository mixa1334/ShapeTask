package com.epam.spahetask.parser.impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.parser.QuadrangleParameterParser;
import com.epam.spahetask.validator.impl.QuadrangleParameterValidatorImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleParameterParserImplTest {
    PointFactory factory;
    QuadrangleParameterParser parser;

    @BeforeClass
    public void setUp() {
        factory = PointFactory.INSTANCE;
        parser = new QuadrangleParameterParserImpl(QuadrangleParameterValidatorImpl.getInstance());
    }

    @Test
    public void testParseParametersPositiveOutcome() throws ShapeException {
        String input = "   1,2    -5,2  2,3  9,-6  ";  //," 1,2    -5,2  2,3  9,-6  -5,4");
        List<CustomPoint> expected = List.of(factory.createPoint(1, 2),
                factory.createPoint(-5, 2),
                factory.createPoint(2, 3),
                factory.createPoint(9, -6));

        List<CustomPoint> actual = parser.parseParameters(input);

        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void testParseParametersNegativeOutcome() throws ShapeException {
        String input = "   1,2    -5,2  2,3  9,-6  7,999";  //," 1,2    -5,2  2,3  9,-6  -5,4");

        parser.parseParameters(input);
    }
}