package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.factory.impl.QuadrangleFactoryImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleTypeCheckerImplTest {
    PointFactory pointFactory;
    QuadrangleFactoryImpl quadrangleFactory;
    QuadrangleTypeCheckerImpl polygonTypeChecker;
    List<CustomPoint> points;

    @BeforeClass
    public void init() {
        pointFactory = PointFactory.INSTANCE;
        quadrangleFactory = QuadrangleFactoryImpl.INSTANCE;
        polygonTypeChecker = QuadrangleTypeCheckerImpl.getInstance();
        points = new ArrayList<>(4);
    }

    @BeforeMethod
    public void setUp() {
        points.clear();
    }

    @Test
    public void testIsQuadranglePositiveOutcome() {
        CustomPoint point1 = pointFactory.createPoint(8, 2);
        CustomPoint point2 = pointFactory.createPoint(14, 2);
        CustomPoint point3 = pointFactory.createPoint(14, -2);
        CustomPoint point4 = pointFactory.createPoint(8, -2);

        List<CustomPoint> input = List.of(point1, point2, point3, point4);

        boolean actual = polygonTypeChecker.isQuadrangle(input);

        assertTrue(actual);
    }

    @Test
    public void testIsQuadrangleNegativeOutcome() {
        CustomPoint point1 = pointFactory.createPoint(2, 2);
        CustomPoint point2 = pointFactory.createPoint(8, 5);
        CustomPoint point3 = pointFactory.createPoint(9, 4);
        CustomPoint point4 = pointFactory.createPoint(11, 2);

        List<CustomPoint> input = List.of(point1, point2, point3, point4);

        boolean actual = polygonTypeChecker.isQuadrangle(input);

        assertFalse(actual);
    }

    @Test
    public void testIsConvexPositive() throws ShapeException {
        points.add(pointFactory.createPoint(3, 1));
        points.add(pointFactory.createPoint(4, 6));
        points.add(pointFactory.createPoint(10, 6));
        points.add(pointFactory.createPoint(8, 2));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isConvex(quadrangle);

        assertTrue(actual);
    }

    @Test
    public void testIsConvexNegative() throws ShapeException {
        points.add(pointFactory.createPoint(9, 5));
        points.add(pointFactory.createPoint(4, 6));
        points.add(pointFactory.createPoint(10, 6));
        points.add(pointFactory.createPoint(8, 2));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isConvex(quadrangle);

        assertFalse(actual);
    }

    @Test
    public void testIsTrapezoidPositive() throws ShapeException {
        points.add(pointFactory.createPoint(2, 3));
        points.add(pointFactory.createPoint(6, 6));
        points.add(pointFactory.createPoint(10, 6));
        points.add(pointFactory.createPoint(4, 3));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isTrapezoid(quadrangle);

        assertTrue(actual);
    }

    @Test
    public void testIsTrapezoidNegative() throws ShapeException {
        points.add(pointFactory.createPoint(2, 3));
        points.add(pointFactory.createPoint(6, 6));
        points.add(pointFactory.createPoint(10, 6));
        points.add(pointFactory.createPoint(1, 2));

        Quadrangle quadrangle = quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isTrapezoid(quadrangle);

        assertFalse(actual);
    }

    @Test
    public void testIsParallelogramPositive() throws ShapeException {
        points.add(pointFactory.createPoint(1, 1));
        points.add(pointFactory.createPoint(4, 4));
        points.add(pointFactory.createPoint(6, 4));
        points.add(pointFactory.createPoint(3, 1));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isParallelogram(quadrangle);

        assertTrue(actual);
    }

    @Test
    public void testIsParallelogramNegative() throws ShapeException {
        points.add(pointFactory.createPoint(1, 1));
        points.add(pointFactory.createPoint(4, 4));
        points.add(pointFactory.createPoint(6, 4));
        points.add(pointFactory.createPoint(5, 1));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isParallelogram(quadrangle);

        assertFalse(actual);
    }

    @Test
    public void testIsRectanglePositive() throws ShapeException {
        points.add(pointFactory.createPoint(0, 5));
        points.add(pointFactory.createPoint(3, 2));
        points.add(pointFactory.createPoint(-3, -4));
        points.add(pointFactory.createPoint(-6, -1));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isRectangle(quadrangle);

        assertTrue(actual);
    }

    @Test
    public void testIsRectangleNegative() throws ShapeException {
        points.add(pointFactory.createPoint(0, 5));
        points.add(pointFactory.createPoint(6, 2));
        points.add(pointFactory.createPoint(-3, -4));
        points.add(pointFactory.createPoint(-6, -1));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isRectangle(quadrangle);

        assertFalse(actual);
    }

    @Test
    public void testIsRhombusPositive() throws ShapeException {
        points.add(pointFactory.createPoint(0, 5));
        points.add(pointFactory.createPoint(2, 0));
        points.add(pointFactory.createPoint(0, -5));
        points.add(pointFactory.createPoint(-2, 0));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isRhombus(quadrangle);

        assertTrue(actual);
    }

    @Test
    public void testIsRhombusNegative() throws ShapeException {
        points.add(pointFactory.createPoint(1, 1));
        points.add(pointFactory.createPoint(4, 4));
        points.add(pointFactory.createPoint(6, 4));
        points.add(pointFactory.createPoint(3, 1));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isRhombus(quadrangle);

        assertFalse(actual);
    }

    @Test
    public void testIsSquarePositive() throws ShapeException {
        points.add(pointFactory.createPoint(0, 3));
        points.add(pointFactory.createPoint(2, -2));
        points.add(pointFactory.createPoint(7, 0));
        points.add(pointFactory.createPoint(5, 5));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isSquare(quadrangle);

        assertTrue(actual);
    }

    @Test
    public void testIsSquareNegative() throws ShapeException {
        points.add(pointFactory.createPoint(0, 5));
        points.add(pointFactory.createPoint(2, 0));
        points.add(pointFactory.createPoint(0, -5));
        points.add(pointFactory.createPoint(-2, 0));

        Quadrangle quadrangle = (Quadrangle) quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isSquare(quadrangle);

        assertFalse(actual);
    }
}