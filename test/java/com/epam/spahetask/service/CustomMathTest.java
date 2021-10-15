package com.epam.spahetask.service;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.factory.PointFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomMathTest {
    CustomPoint point1;
    CustomPoint point2;
    CustomPoint point3;
    CustomPoint point4;
    PointFactory pointFactory = PointFactory.INSTANCE;
    CustomMath customMath = CustomMath.INSTANCE;

    @BeforeMethod
    public void setUp() {
        point1 = pointFactory.createPoint(8, 2);
        point2 = pointFactory.createPoint(14, 2);
        point3 = pointFactory.createPoint(14, -2);
        point4 = pointFactory.createPoint(8, -2);
    }

    @Test
    public void testAreLinesParallelPositive() {
        boolean actual = customMath.areLinesParallelOrPerpendicular(point1, point2, point3, point4, CustomMath.LinesType.PARALLEL);

        assertTrue(actual);
    }

    @Test
    public void testAreLinesParallelNegative() {
        boolean actual = customMath.areLinesParallelOrPerpendicular(point1, point2, point2, point3, CustomMath.LinesType.PARALLEL);

        assertFalse(actual);
    }


    @Test
    public void testAreLinesPerpendicularPositive() {
        boolean actual = customMath.areLinesParallelOrPerpendicular(point1, point2, point2, point3, CustomMath.LinesType.PERPENDICULAR);

        assertTrue(actual);
    }

    @Test
    public void testAreLinesPerpendicularNegative() {
        boolean actual = customMath.areLinesParallelOrPerpendicular(point1, point2, point3, point4, CustomMath.LinesType.PERPENDICULAR);

        assertFalse(actual);
    }

    @Test
    public void testIsLineVerticalPositive() {
        boolean actual = customMath.isLineVertical(point1, point4);

        assertTrue(actual);
    }

    @Test
    public void testIsLineVerticalNegative() {
        boolean actual = customMath.isLineVertical(point1, point2);

        assertFalse(actual);
    }

    @Test
    public void testIsLineHorizontalPositive() {
        boolean actual = customMath.isLineHorizontal(point1, point2);

        assertTrue(actual);
    }

    @Test
    public void testIsLineHorizontalNegative() {
        boolean actual = customMath.isLineHorizontal(point1, point4);

        assertFalse(actual);
    }

    @Test
    public void testCalculateLineBtwTwoPointsPositive() {
        double actual = customMath.calculateLineBtwTwoPoints(point1, point3);
        double expected = Math.hypot(4, 6);

        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateAngel34() {
        point1 = pointFactory.createPoint(3, 4);
        point2 = pointFactory.createPoint(1, 1);
        point3 = pointFactory.createPoint(6, 3);
        double actual = customMath.calculateAngel(point1, point2, point3);
        double expected = 34.5085229876684;

        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateAngel90() {
        double actual = customMath.calculateAngel(point1, point2, point3);
        double expected = 90;

        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateAngel0() {
        point1 = pointFactory.createPoint(1, 1);
        point2 = pointFactory.createPoint(2, 2);
        point3 = pointFactory.createPoint(3, 3);
        double actual = customMath.calculateAngel(point1, point2, point3);
        double expected = 0;

        assertEquals(actual, expected);
    }
}