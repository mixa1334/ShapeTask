package com.epam.spahetask.factory;

import com.epam.spahetask.entity.CustomPoint;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PointFactoryTest {
    PointFactory factory = new PointFactory();

    @Test
    public void testCreatePoint() {
        CustomPoint point = factory.createPoint(1, 2);
        int expectedX = 1;
        int expectedY = 2;

        boolean actual = expectedX == point.getX() && expectedY == point.getY();

        assertTrue(actual);
    }

    @Test
    public void testTestCreatePoint() {
        CustomPoint point1 = factory.createPoint(5, -2);
        CustomPoint point2 = factory.createPoint(point1);
        point1.setY(0);
        point1.setX(-99);

        int expectedX = 5;
        int expectedY = -2;

        boolean actual = point2.getX() == expectedX && point2.getY() == expectedY;

        assertTrue(actual);
    }

    @Test
    public void testCopyPoints() {
        CustomPoint point1 = factory.createPoint(8, 9);
        CustomPoint point2 = factory.createPoint(-10, 0);
        CustomPoint point3 = factory.createPoint(1, 1);
        List<CustomPoint> expected = new ArrayList<>(3);
        expected.add(point1);
        expected.add(point2);
        expected.add(point3);

        List<CustomPoint> actual = factory.copyPoints(expected);

        point1.setX(-99);

        assertNotEquals(actual, expected);
    }
}