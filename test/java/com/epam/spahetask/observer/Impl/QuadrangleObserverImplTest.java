package com.epam.spahetask.observer.Impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.factory.QuadrangleFactory;
import com.epam.spahetask.factory.impl.QuadrangleFactoryImpl;
import com.epam.spahetask.warehouse.QuadrangleParameter;
import com.epam.spahetask.warehouse.Warehouse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleObserverImplTest {
    Warehouse warehouse = Warehouse.getInstance();
    QuadrangleFactory quadrangleFactory = QuadrangleFactoryImpl.INSTANCE;
    PointFactory pointFactory = PointFactory.INSTANCE;
    Quadrangle quadrangle;


    @BeforeClass
    public void setUp() throws ShapeException {
        List<CustomPoint> points = List.of(pointFactory.createPoint(3, 5), pointFactory.createPoint(8, 5),
                pointFactory.createPoint(8, 1), pointFactory.createPoint(3, 1));

        quadrangle = quadrangleFactory.createPolygon(points);

        QuadrangleParameter parameter = new QuadrangleParameter(20, 18);

        warehouse.put(quadrangle.getPolygonId(), parameter);
    }

    @Test
    public void testUpdate() throws ShapeException {
        List<CustomPoint> points = List.of(pointFactory.createPoint(-1, -1), pointFactory.createPoint(3, -8),
                pointFactory.createPoint(1, -9), pointFactory.createPoint(-3, -6));

        QuadrangleParameter expected = new QuadrangleParameter(22, 20.683490532932844);

        quadrangle.setPoints(points);

        QuadrangleParameter actual = warehouse.get(quadrangle.getPolygonId()).get();

        assertEquals(actual, expected);
    }
}