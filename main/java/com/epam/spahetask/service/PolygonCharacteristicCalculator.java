package com.epam.spahetask.service;

import com.epam.spahetask.entity.polygon.Polygon;

import java.util.Optional;

public interface PolygonCharacteristicCalculator {
    Optional<Long> calculateArea(Polygon polygon);

    Optional<Long> calculatePerimeter(Polygon polygon);
}
