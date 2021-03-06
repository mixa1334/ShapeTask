package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.service.CustomMath;
import com.epam.spahetask.service.QuadrangleCharacteristicCalculator;
import com.epam.spahetask.service.QuadrangleTypeChecker;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class QuadrangleCharacteristicCalculatorImpl implements QuadrangleCharacteristicCalculator {
    final static Logger logger = LogManager.getLogger();
    private final static QuadrangleCharacteristicCalculatorImpl instance = new QuadrangleCharacteristicCalculatorImpl();
    private final QuadrangleTypeChecker checker = QuadrangleTypeCheckerImpl.getInstance();
    private final CustomMath customMath = CustomMath.INSTANCE;

    private QuadrangleCharacteristicCalculatorImpl() {
    }

    public static QuadrangleCharacteristicCalculatorImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<Double> calculateArea(Quadrangle quadrangle) {
        if (!checker.isConvex(quadrangle)) {
            logger.log(Level.INFO, "it is not convex polygon!");
            return Optional.empty();
        }

        List<CustomPoint> pointList = quadrangle.getAllPoints();

        CustomPoint point1;
        CustomPoint point2;
        double partOne = 0;
        double partTwo = 0;
        int n = pointList.size() - 1;

        for (int i = 0; i < n; i++) {
            point1 = pointList.get(i);
            point2 = pointList.get(i + 1);
            partOne += point1.getX() * point2.getY();
            partTwo += point2.getX() * point1.getY();
        }
        point1 = pointList.get(n);
        point2 = pointList.get(0);
        partOne += point1.getX() * point2.getY();
        partTwo += point2.getX() * point1.getY();

        double result = Math.abs(partOne - partTwo);
        result /= 2;
        logger.log(Level.INFO, "result [area] - " + result);

        return Optional.of(result);
    }

    @Override
    public Optional<Double> calculatePerimeter(Quadrangle quadrangle) {
        if (!checker.isConvex(quadrangle)) {
            logger.log(Level.INFO, "it is not convex polygon!");
            return Optional.empty();
        }

        List<CustomPoint> pointList = quadrangle.getAllPoints();

        CustomPoint point1 = pointList.get(0);
        CustomPoint point2 = pointList.get(1);
        CustomPoint point3 = pointList.get(2);
        CustomPoint point4 = pointList.get(3);

        double size1 = customMath.calculateLineBtwTwoPoints(point1, point2);
        double size2 = customMath.calculateLineBtwTwoPoints(point2, point3);
        double size3 = customMath.calculateLineBtwTwoPoints(point3, point4);
        double size4 = customMath.calculateLineBtwTwoPoints(point4, point1);
        logger.log(Level.DEBUG, "Quadrangle - " + quadrangle);
        StringBuilder message = new StringBuilder();
        message.append("line 1,2,3,4 - ")
                .append(size1)
                .append("\\")
                .append(size2)
                .append("\\")
                .append(size3)
                .append("\\")
                .append(size4);
        logger.log(Level.DEBUG, message);
        double result = size1 + size2 + size3 + size4;

        logger.log(Level.INFO, "perimeter - " + result);

        return Optional.of(result);
    }
}
