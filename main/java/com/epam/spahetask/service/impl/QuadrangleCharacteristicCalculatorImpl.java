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

//todo refactoring
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

        double result = Math.abs(calculatePartOfArea(pointList, 1) - calculatePartOfArea(pointList, 2));
        result /= 2;

        logger.log(Level.INFO, "result [area1 - area2]- " + result);

        return Optional.of(result);
    }

    private double calculatePartOfArea(List<CustomPoint> pointList, int part) {
        int n = pointList.size() - 1;
        double result = 0;
        double temp;
        CustomPoint pointX;
        CustomPoint pointY;

        for (int i = 0; i < n; i++) {
            if (part == 1) {
                pointX = pointList.get(i);
                pointY = pointList.get(i + 1);
            } else {
                pointX = pointList.get(i + 1);
                pointY = pointList.get(i);
            }
            temp = pointX.getX() * pointY.getY();
            result += temp;
        }
        if (part == 1) {
            pointX = pointList.get(n);
            pointY = pointList.get(0);
        } else {
            pointX = pointList.get(0);
            pointY = pointList.get(n);
        }
        temp = pointX.getX() * pointY.getY();
        result += temp;

        logger.log(Level.DEBUG, "part of area - " + result);

        return result;
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
        double result = size1 + size2 + size3 + size4;

        logger.log(Level.INFO, "perimeter - " + result);

        return Optional.of(result);
    }
}
