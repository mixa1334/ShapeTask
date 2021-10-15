package com.epam.spahetask.factory;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;

import java.util.List;

public interface PolygonFactory {
    Polygon createPolygon(Polygon polygon) throws ShapeException;

    Polygon createPolygon(List<CustomPoint> points) throws ShapeException;
}
