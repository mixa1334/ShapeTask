package com.epam.spahetask.service;

import com.epam.spahetask.entity.polygon.Polygon;

public interface PolygonTypeChecker {
    boolean isConvex(Polygon polygon);

    boolean isRectangle(Polygon polygon);

    boolean isSquare(Polygon polygon);

    boolean isRhombus(Polygon polygon);

    boolean isTrapezoid(Polygon polygon);
}
