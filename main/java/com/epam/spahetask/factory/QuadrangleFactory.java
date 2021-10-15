package com.epam.spahetask.factory;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;

import java.util.List;

public interface QuadrangleFactory {
    Quadrangle createPolygon(Quadrangle polygon) throws ShapeException;

    Quadrangle createPolygon(List<CustomPoint> points) throws ShapeException;
}
