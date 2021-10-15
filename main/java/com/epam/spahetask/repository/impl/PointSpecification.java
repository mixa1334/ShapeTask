package com.epam.spahetask.repository.impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.repository.QuadrangleSpecification;

public record PointSpecification(CustomPoint point) implements QuadrangleSpecification {
    @Override
    public boolean test(Quadrangle quadrangle) {
        return quadrangle.getAllPoints().contains(point);
    }
}
