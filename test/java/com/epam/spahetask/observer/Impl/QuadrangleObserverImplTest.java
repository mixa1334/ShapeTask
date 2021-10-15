package com.epam.spahetask.observer.Impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.factory.QuadrangleFactory;
import com.epam.spahetask.factory.impl.QuadrangleFactoryImpl;
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

    }

    @Test
    public void testUpdate() {
        
    }
}