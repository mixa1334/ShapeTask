package com.epam.spahetask.validator;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.factory.PointFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleValidatorTest {

    @Test
    public void testIsQuadranglePositiveOutcome() {
        CustomPoint point1 = PointFactory.createPoint(2,2);
        CustomPoint point2 = PointFactory.createPoint(8,5);
        CustomPoint point3 = PointFactory.createPoint(9,4);
        CustomPoint point4 = PointFactory.createPoint(8,1);

        List<CustomPoint> input = List.of(point1, point2, point3, point4);

        boolean actual = QuadrangleValidator.isQuadrangle(input);

        assertTrue(actual);
    }

    @Test
    public void testIsQuadrangleNegativeOutcome() {
        CustomPoint point1 = PointFactory.createPoint(2,2);
        CustomPoint point2 = PointFactory.createPoint(8,5);
        CustomPoint point3 = PointFactory.createPoint(9,4);
        CustomPoint point4 = PointFactory.createPoint(11,2);

        List<CustomPoint> input = List.of(point1, point2, point3, point4);

        boolean actual = QuadrangleValidator.isQuadrangle(input);

        assertFalse(actual);
    }
}