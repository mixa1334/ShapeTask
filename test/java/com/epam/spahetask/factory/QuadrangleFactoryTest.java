package com.epam.spahetask.factory;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.impl.QuadrangleFactoryImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleFactoryTest {
    PointFactory pointFactory;
    QuadrangleFactory quadrangleFactory;

    @BeforeClass
    public void setUp() {
        pointFactory = PointFactory.INSTANCE;
        quadrangleFactory = QuadrangleFactoryImpl.INSTANCE;
    }

    @Test
    public void testCreateQuadranglePositive() throws ShapeException {
        List<CustomPoint> pointList = new ArrayList<>(4);
        pointList.add(pointFactory.createPoint(4, 1));
        pointList.add(pointFactory.createPoint(5, 4));
        pointList.add(pointFactory.createPoint(7, 5));
        pointList.add(pointFactory.createPoint(10, 1));

        Quadrangle quadrangle = quadrangleFactory.createPolygon(pointList);

        assertEquals(quadrangle.getAllPoints(), pointList);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void testCreateQuadrangleNegative() throws ShapeException {
        List<CustomPoint> pointList = new ArrayList<>(4);
        pointList.add(pointFactory.createPoint(4, 1));
        pointList.add(pointFactory.createPoint(5, 4));

        Quadrangle quadrangle = quadrangleFactory.createPolygon(pointList);

    }

    @Test
    public void testCreateQuadrangleFromQuadrangle() throws ShapeException {
        List<CustomPoint> pointList = new ArrayList<>(4);
        pointList.add(pointFactory.createPoint(4, 1));
        pointList.add(pointFactory.createPoint(5, 4));
        pointList.add(pointFactory.createPoint(7, 5));
        pointList.add(pointFactory.createPoint(10, 1));

        Quadrangle expected = quadrangleFactory.createPolygon(pointList);
        Quadrangle actual = quadrangleFactory.createPolygon(expected);

        assertNotEquals(actual, expected);
    }
}