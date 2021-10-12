package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.polygon.quadrangle.Quadrangle;
import com.epam.spahetask.service.QuadrangleTypeChecker;

//todo
public class QuadrangleTypeCheckerImpl implements QuadrangleTypeChecker {
    @Override
    public boolean isConvex(Quadrangle quadrangle) {
        return false;
    }

    @Override
    public boolean isRectangle(Quadrangle quadrangle) {
        return false;
    }

    @Override
    public boolean isSquare(Quadrangle quadrangle) {
        return false;
    }

    @Override
    public boolean isRhombus(Quadrangle quadrangle) {
        return false;
    }

    @Override
    public boolean isTrapezoid(Quadrangle quadrangle) {
        return false;
    }
}
