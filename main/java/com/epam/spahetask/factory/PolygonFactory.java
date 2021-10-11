package com.epam.spahetask.factory;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;

public interface PolygonFactory {
    Polygon createPolygon(CustomPoint ... points) throws ShapeException;
}
