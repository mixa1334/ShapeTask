package com.epam.spahetask.factory;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
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
        pointFactory = new PointFactory();
        quadrangleFactory = new QuadrangleFactory();
    }

    @Test
    public void testCreateQuadranglePositive() throws ShapeException {
        List<CustomPoint> pointList = new ArrayList<>(4);
        pointList.add(pointFactory.createPoint(4, 1));
        pointList.add(pointFactory.createPoint(5, 4));
        pointList.add(pointFactory.createPoint(7, 5));
        pointList.add(pointFactory.createPoint(10, 1));

        Quadrangle quadrangle = quadrangleFactory.createQuadrangle(pointList);

        assertEquals(quadrangle.getAllPoints(), pointList);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void testCreateQuadrangleNegative() throws ShapeException {
        List<CustomPoint> pointList = new ArrayList<>(4);
        pointList.add(pointFactory.createPoint(4, 1));
        pointList.add(pointFactory.createPoint(5, 4));

        Quadrangle quadrangle = quadrangleFactory.createQuadrangle(pointList);

    }

    @Test
    public void testCreateQuadrangleFromQuadrangle() throws ShapeException {
        List<CustomPoint> pointList = new ArrayList<>(4);
        pointList.add(pointFactory.createPoint(4, 1));
        pointList.add(pointFactory.createPoint(5, 4));
        pointList.add(pointFactory.createPoint(7, 5));
        pointList.add(pointFactory.createPoint(10, 1));

        Quadrangle expected = quadrangleFactory.createQuadrangle(pointList);
        Quadrangle actual = quadrangleFactory.createQuadrangle(expected);

        assertNotEquals(actual, expected);
    }
}