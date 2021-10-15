package com.epam.spahetask.repository.impl;

import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.repository.QuadrangleSpecification;
import com.epam.spahetask.warehouse.QuadrangleParameter;
import com.epam.spahetask.warehouse.Warehouse;

import java.util.Optional;

public record AreaSpecification(double minArea, double maxArea) implements QuadrangleSpecification {
    @Override
    public boolean test(Quadrangle quadrangle) {
        Warehouse warehouse = Warehouse.getInstance();
        Optional<QuadrangleParameter> parameter = warehouse.get(quadrangle.getQuadrangleId());
        if (parameter.isEmpty()) {
            return false;
        }
        double area = parameter.get().getArea();

        return minArea <= area && maxArea >= area;
    }
}
