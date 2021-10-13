package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.service.PolygonCharacteristicCalculator;
import com.epam.spahetask.service.PolygonTypeChecker;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

//todo
public class PolygonCharacteristicCalculatorImpl implements PolygonCharacteristicCalculator {
    final static Logger logger = LogManager.getLogger();
    private final PolygonTypeChecker checker = new PolygonTypeCheckerImpl();

    @Override
    public Optional<Double> calculateArea(Polygon polygon) {
        if (!checker.isConvex(polygon)) {
            logger.log(Level.INFO, "it is not convex polygon!");
            return Optional.empty();
        }

        List<CustomPoint> pointList = polygon.getPoints();

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
    public Optional<Double> calculatePerimeter(Polygon polygon) {
        if (!checker.isConvex(polygon)) {
            logger.log(Level.INFO, "it is not convex polygon!");
            return Optional.empty();
        }

        List<CustomPoint> pointList = polygon.getPoints();

        CustomPoint pointOne;
        CustomPoint pointTwo;

        double result = 0;
        int n = pointList.size() - 1;

        for (int i = 0; i < n; i++) {
            pointOne = pointList.get(i);
            pointTwo = pointList.get(i + 1);
            result += calculateLineBtwTwoPoints(pointOne, pointTwo);
        }
        pointOne = pointList.get(n);
        pointTwo = pointList.get(0);
        result += calculateLineBtwTwoPoints(pointOne, pointTwo);

        logger.log(Level.INFO, "perimeter - " + result);

        return Optional.of(result);
    }

    private double calculateLineBtwTwoPoints(CustomPoint point1, CustomPoint point2) {
        double dx = point2.getX() - point1.getX();
        double dy = point2.getY() - point1.getY();

        return Math.hypot(dx, dy);
    }
}
