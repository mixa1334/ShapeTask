package com.epam.spahetask.validator;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.factory.PointFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleValidatorTest {
    PointFactory factory = new PointFactory();

    @Test
    public void testIsQuadranglePositiveOutcome() {
        CustomPoint point1 = factory.createPoint(2, 2);
        CustomPoint point2 = factory.createPoint(8, 5);
        CustomPoint point3 = factory.createPoint(9, 4);
        CustomPoint point4 = factory.createPoint(8, 1);

        List<CustomPoint> input = List.of(point1, point2, point3, point4);

        boolean actual = QuadrangleValidator.isQuadrangle(input);

        assertTrue(actual);
    }

    @Test
    public void testIsQuadrangleNegativeOutcome() {
        CustomPoint point1 = factory.createPoint(2, 2);
        CustomPoint point2 = factory.createPoint(8, 5);
        CustomPoint point3 = factory.createPoint(9, 4);
        CustomPoint point4 = factory.createPoint(11, 2);

        List<CustomPoint> input = List.of(point1, point2, point3, point4);

        boolean actual = QuadrangleValidator.isQuadrangle(input);

        assertFalse(actual);
    }
}