package com.epam.spahetask.service;

import com.epam.spahetask.entity.polygon.Polygon;

import java.util.Optional;

public interface PolygonCharacteristicCalculator {
    Optional<Double> calculateArea(Polygon polygon);

    Optional<Double> calculatePerimeter(Polygon polygon);
}
