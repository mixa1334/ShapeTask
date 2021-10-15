package com.epam.spahetask.factory.impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.entity.polygon.quadrangle.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PolygonFactory;
import com.epam.spahetask.service.QuadrangleTypeChecker;
import com.epam.spahetask.service.impl.QuadrangleTypeCheckerImpl;

import java.util.List;

public class QuadrangleFactory implements PolygonFactory {
    private static QuadrangleFactory instance = new QuadrangleFactory();

    private QuadrangleFactory() {
    }

    public static QuadrangleFactory getInstance() {
        return instance;
    }

    @Override
    public Polygon createPolygon(Polygon polygon) throws ShapeException {
        return createPolygon(polygon.getAllPoints());
    }

    @Override
    public Polygon createPolygon(List<CustomPoint> points) throws ShapeException {
        QuadrangleTypeChecker quadrangleTypeChecker = QuadrangleTypeCheckerImpl.getInstance();
        if (!quadrangleTypeChecker.isQuadrangle(points)) {
            throw new ShapeException(points + " is not quadrangle");
        }

        Quadrangle polygon = new Quadrangle();
        polygon.setPoints(points);

        return polygon;
    }
}
