package com.epam.spahetask.service;

import com.epam.spahetask.entity.polygon.quadrangle.Quadrangle;

public interface QuadrangleTypeChecker {
    boolean isConvex(Quadrangle quadrangle);

    boolean isRectangle(Quadrangle quadrangle);

    boolean isSquare(Quadrangle quadrangle);

    boolean isRhombus(Quadrangle quadrangle);

    boolean isTrapezoid(Quadrangle quadrangle);
}
