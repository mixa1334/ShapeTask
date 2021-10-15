package com.epam.spahetask.repository.impl;

import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.repository.QuadrangleSpecification;
import com.epam.spahetask.service.impl.QuadrangleTypeCheckerImpl;

public record RectangleSpecification() implements QuadrangleSpecification {
    @Override
    public boolean test(Quadrangle quadrangle) {
        return QuadrangleTypeCheckerImpl.getInstance().isRectangle(quadrangle);
    }
}
