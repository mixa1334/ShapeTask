package com.epam.spahetask.entity.polygon;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.exception.ShapeException;

import java.util.List;

public interface Polygon {
    List<CustomPoint> getPoints();

    void setPoints(List<CustomPoint> points) throws ShapeException;

    long getPolygonId();
}
