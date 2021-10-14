package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.factory.PolygonFactory;
import com.epam.spahetask.factory.quadranglefactory.QuadrangleFactory;
import com.epam.spahetask.service.PolygonCharacteristicCalculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PolygonCharacteristicCalculatorImplTest {
    PolygonCharacteristicCalculator polygonCharacteristicCalculator;
    PointFactory pointFactory;
    PolygonFactory polygonFactory;
    Polygon quadrangle;

    @BeforeClass
    public void setUp() throws ShapeException {
        polygonCharacteristicCalculator = new PolygonCharacteristicCalculatorImpl();
        pointFactory = new PointFactory();
        polygonFactory = new QuadrangleFactory();
        List<CustomPoint> points = new ArrayList<>(4);
        points.add(pointFactory.createPoint(4, -1));
        points.add(pointFactory.createPoint(-2, -3));
        points.add(pointFactory.createPoint(-1, 3));
        points.add(pointFactory.createPoint(1, 5));

        quadrangle = polygonFactory.createPolygon(points);
    }

    @Test
    public void testCalculateArea() throws ShapeException {
        double expected = 26;
        double actual = polygonCharacteristicCalculator.calculateArea(quadrangle).get();


        assertEquals(actual, expected);
    }

    @Test
    public void testCalculatePerimeter() throws ShapeException {

        double expected = 21.94394890788054;
        double actual = polygonCharacteristicCalculator.calculatePerimeter(quadrangle).get();


        assertEquals(actual, expected);
    }
}