package com.epam.spahetask.factory;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;

import java.util.List;

public interface PolygonFactory {
    Polygon createPolygon(List<CustomPoint> points) throws ShapeException;
}
