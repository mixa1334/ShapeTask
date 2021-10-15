package com.epam.spahetask.observer.Impl;

import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.observer.QuadrangleEvent;
import com.epam.spahetask.observer.QuadrangleObserver;
import com.epam.spahetask.service.QuadrangleCharacteristicCalculator;
import com.epam.spahetask.service.impl.QuadrangleCharacteristicCalculatorImpl;
import com.epam.spahetask.warehouse.QuadrangleParameter;
import com.epam.spahetask.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class QuadrangleObserverImpl implements QuadrangleObserver {
    final static Logger logger = LogManager.getLogger();
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

        double newArea = area.get();
        double newPerimeter = perimeter.get();
        logger.log(Level.INFO, "new area ");
        QuadrangleParameter parameter = new QuadrangleParameter(newArea, newPerimeter);

        return warehouse.update(quadrangle.getQuadrangleId(), parameter);
    }
}
