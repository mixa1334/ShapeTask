package com.epam.spahetask.service;

import com.epam.spahetask.entity.Quadrangle;

import java.util.Optional;

public interface QuadrangleCharacteristicCalculator {
    Optional<Double> calculateArea(Quadrangle quadrangle);

    Optional<Double> calculatePerimeter(Quadrangle quadrangle);
}
