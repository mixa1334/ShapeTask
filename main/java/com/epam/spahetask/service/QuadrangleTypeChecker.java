package com.epam.spahetask.service;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.polygon.quadrangle.Quadrangle;

import java.util.List;

public interface QuadrangleTypeChecker {
    boolean isQuadrangle(List<CustomPoint> pointList);

    boolean isTrapezoid(Quadrangle quadrangle);

    boolean isParallelogram(Quadrangle quadrangle);

    boolean isRectangle(Quadrangle quadrangle);

    boolean isRhombus(Quadrangle quadrangle);

    boolean isSquare(Quadrangle quadrangle);
}