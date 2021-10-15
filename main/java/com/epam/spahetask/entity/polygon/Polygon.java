package com.epam.spahetask.entity.polygon;

import com.epam.spahetask.entity.AbstractShape;
import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.exception.ShapeException;

import java.util.List;

public abstract class Polygon implements AbstractShape {
    abstract public List<CustomPoint> getAllPoints();

    abstract public void setPoints(List<CustomPoint> points) throws ShapeException;

    abstract public long getPolygonId();
}
