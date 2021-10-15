package com.epam.spahetask.repository.impl;

import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.repository.QuadrangleSpecification;

public record IdSpecification(long lowRange, long highRange) implements QuadrangleSpecification {
    @Override
    public boolean test(Quadrangle quadrangle) {
        long quadrangleId = quadrangle.getQuadrangleId();
        return lowRange <= quadrangleId && highRange >= quadrangleId;
    }
}
