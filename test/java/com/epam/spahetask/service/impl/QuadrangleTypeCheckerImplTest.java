package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.factory.quadranglefactory.QuadrangleFactory;
import com.epam.spahetask.service.PolygonTypeChecker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleTypeCheckerImplTest {
    PointFactory pointFactory;
    QuadrangleFactory quadrangleFactory;
    PolygonTypeChecker polygonTypeChecker;

    @BeforeClass
    public void setUp() {
        pointFactory = new PointFactory();
        quadrangleFactory = new QuadrangleFactory();
        polygonTypeChecker = new PolygonTypeCheckerImpl();
    }

    @Test
    public void testIsConvexPositive() throws ShapeException {
        List<CustomPoint> points = new ArrayList<>(4);
        points.add(pointFactory.createPoint(3, 1));
        points.add(pointFactory.createPoint(4, 6));
        points.add(pointFactory.createPoint(10, 6));
        points.add(pointFactory.createPoint(8, 2));

        Polygon quadrangle = quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isConvex(quadrangle);

        assertTrue(actual);
    }

    @Test
    public void testIsConvexNegative() throws ShapeException {
        List<CustomPoint> points = new ArrayList<>(4);
        points.add(pointFactory.createPoint(9, 5));
        points.add(pointFactory.createPoint(4, 6));
        points.add(pointFactory.createPoint(10, 6));
        points.add(pointFactory.createPoint(8, 2));

        Polygon quadrangle = quadrangleFactory.createPolygon(points);

        boolean actual = polygonTypeChecker.isConvex(quadrangle);

        assertFalse(actual);
    }
}