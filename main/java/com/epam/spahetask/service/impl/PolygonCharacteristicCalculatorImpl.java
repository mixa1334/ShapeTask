package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.service.PolygonCharacteristicCalculator;
import com.epam.spahetask.service.PolygonTypeChecker;

import java.util.List;
import java.util.Optional;

//todo
public class PolygonCharacteristicCalculatorImpl implements PolygonCharacteristicCalculator {
    private final PolygonTypeChecker checker = new PolygonTypeCheckerImpl();

    @Override
    public Optional<Long> calculateArea(Polygon polygon) {
        if (checker.isConvex(polygon)) {
            return Optional.empty();
        }

        List<CustomPoint> pointList = polygon.getPoints();


    }

    @Override
    public Optional<Long> calculatePerimeter(Polygon polygon) {
        return Optional.empty();
    }
}
