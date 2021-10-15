package com.epam.spahetask.service;

import com.epam.spahetask.entity.polygon.Polygon;

public interface PolygonTypeChecker {
    boolean isConvex(Polygon quadrangle);
}
