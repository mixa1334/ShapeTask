package com.epam.spahetask.validator;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.factory.PointFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleValidatorTest {

    @Test
    public void testIsQuadranglePositiveOutcome() {
        CustomPoint point1 = PointFactory.createPoint(2,2);
        CustomPoint point2 = PointFactory.createPoint(8,5);
        CustomPoint point3 = PointFactory.createPoint(9,4);
        CustomPoint point4 = PointFactory.createPoint(8,1);

        boolean actual = QuadrangleValidator.isQuadrangle(point1, point2, point3, point4);

        assertTrue(actual);
    }

    @Test
    public void testIsQuadrangleNegativeOutcome() {
        CustomPoint point1 = PointFactory.createPoint(2,2);
        CustomPoint point2 = PointFactory.createPoint(8,5);
        CustomPoint point3 = PointFactory.createPoint(9,4);
        CustomPoint point4 = PointFactory.createPoint(11,2);

        boolean actual = QuadrangleValidator.isQuadrangle(point1, point2, point3, point4);

        assertFalse(actual);
    }
}