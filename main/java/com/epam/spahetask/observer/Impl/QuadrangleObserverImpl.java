package com.epam.spahetask.observer.Impl;

import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.observer.QuadrangleEvent;
import com.epam.spahetask.observer.QuadrangleObserver;
import com.epam.spahetask.service.QuadrangleCharacteristicCalculator;
import com.epam.spahetask.service.impl.QuadrangleCharacteristicCalculatorImpl;
import com.epam.spahetask.warehouse.QuadrangleParameter;
import com.epam.spahetask.warehouse.Warehouse;

import java.util.Optional;

public class QuadrangleObserverImpl implements QuadrangleObserver {
    private final Warehouse warehouse;
    private final QuadrangleCharacteristicCalculator calculator;

    public QuadrangleObserverImpl() {
        warehouse = Warehouse.getInstance();
        calculator = QuadrangleCharacteristicCalculatorImpl.getInstance();
    }

    @Override
    public boolean update(QuadrangleEvent event) {
        Quadrangle quadrangle = event.getSource();

        Optional<Double> area = calculator.calculateArea(quadrangle);
        Optional<Double> perimeter = calculator.calculatePerimeter(quadrangle);

        if (area.isEmpty() || perimeter.isEmpty()) {
            return false;
        }

        QuadrangleParameter parameter = new QuadrangleParameter(area.get(), perimeter.get());

        return warehouse.update(quadrangle.getPolygonId(), parameter);
    }
}
