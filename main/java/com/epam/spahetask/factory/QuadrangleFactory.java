package com.epam.spahetask.factory;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.service.QuadrangleTypeChecker;
import com.epam.spahetask.service.impl.QuadrangleTypeCheckerImpl;

import java.util.List;

public class QuadrangleFactory {
    public Quadrangle createQuadrangle(Quadrangle quadrangle) throws ShapeException {
        return createQuadrangle(quadrangle.getAllPoints());
    }

    public Quadrangle createQuadrangle(List<CustomPoint> points) throws ShapeException {
        QuadrangleTypeChecker quadrangleTypeChecker = QuadrangleTypeCheckerImpl.getInstance();
        if (!quadrangleTypeChecker.isQuadrangle(points)) {
            throw new ShapeException(points + " is not quadrangle");
        }

        Quadrangle polygon = new Quadrangle();
        polygon.setPoints(points);

        return polygon;
    }
}
