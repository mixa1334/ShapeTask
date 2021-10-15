package com.epam.spahetask.factory.impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.QuadrangleFactory;
import com.epam.spahetask.observer.Impl.QuadrangleObserverImpl;
import com.epam.spahetask.service.QuadrangleTypeChecker;
import com.epam.spahetask.service.impl.QuadrangleTypeCheckerImpl;

import java.util.List;

public enum QuadrangleFactoryImpl implements QuadrangleFactory {
    INSTANCE;

    @Override
    public Quadrangle createPolygon(Quadrangle polygon) throws ShapeException {
        return createPolygon(polygon.getAllPoints());
    }

    @Override
    public Quadrangle createPolygon(List<CustomPoint> points) throws ShapeException {
        QuadrangleTypeChecker quadrangleTypeChecker = QuadrangleTypeCheckerImpl.getInstance();
        if (!quadrangleTypeChecker.isQuadrangle(points)) {
            throw new ShapeException(points + " is not quadrangle");
        }

        Quadrangle polygon = new Quadrangle();
        polygon.attach(new QuadrangleObserverImpl());
        polygon.setPoints(points);

        return polygon;
    }
}
