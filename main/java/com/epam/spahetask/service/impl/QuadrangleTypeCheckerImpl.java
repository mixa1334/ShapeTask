package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.entity.polygon.quadrangle.Quadrangle;
import com.epam.spahetask.service.CustomMath;
import com.epam.spahetask.service.PolygonTypeChecker;
import com.epam.spahetask.service.QuadrangleTypeChecker;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleTypeCheckerImpl implements QuadrangleTypeChecker, PolygonTypeChecker {
    final static Logger logger = LogManager.getLogger();
    private static QuadrangleTypeCheckerImpl instance = new QuadrangleTypeCheckerImpl();
    private CustomPoint point1;
    private CustomPoint point2;
    private CustomPoint point3;
    private CustomPoint point4;
    private final CustomMath customMath = CustomMath.INSTANCE;

    private QuadrangleTypeCheckerImpl() {
    }

    public static QuadrangleTypeCheckerImpl getInstance() {
        return instance;
    }

    @Override
    public boolean isQuadrangle(List<CustomPoint> pointList) {
        if (pointList.size() != 4) {
            logger.log(Level.INFO, pointList + " is not quadrangle");
            return false;
        }

        CustomPoint point1 = pointList.get(0);
        CustomPoint point2 = pointList.get(1);
        CustomPoint point3 = pointList.get(2);
        CustomPoint point4 = pointList.get(3);

        boolean firstTrio = customMath.calculateAngel(point1, point2, point3) == 0;
        boolean secondTrio = customMath.calculateAngel(point1, point2, point4) == 0;
        boolean thirdTrio = customMath.calculateAngel(point1, point3, point4) == 0;
        boolean fourthTrio = customMath.calculateAngel(point2, point3, point4) == 0;
        boolean result = !(firstTrio || secondTrio || thirdTrio || fourthTrio);

        logger.log(Level.INFO, pointList + " isQuadrangle?: " + result);
        return result;
    }

    @Override
    public boolean isConvex(Polygon quadrangle) {
        List<CustomPoint> points = quadrangle.getAllPoints();

        point1 = points.get(0);
        point2 = points.get(1);
        point3 = points.get(2);
        point4 = points.get(3);

        boolean sign = false;
        boolean result = true;
        int n = points.size();
        int i = 0;

        while (i < n) {
            double dx1 = points.get((i + 2) % n).getX() - points.get((i + 1) % n).getX();
            double dy1 = points.get((i + 2) % n).getY() - points.get((i + 1) % n).getY();
            double dx2 = points.get(i).getX() - points.get((i + 1) % n).getX();
            double dy2 = points.get(i).getY() - points.get((i + 1) % n).getY();
            double angel = dx1 * dy2 - dy1 * dx2;

            if (i == 0) {
                sign = angel > 0;
            } else if (sign != (angel > 0)) {
                logger.log(Level.INFO, quadrangle + " is not convex");
                result = false;
                break;
            }
            i++;
        }

        logger.log(Level.INFO, quadrangle + " is convex");
        return result;
    }

    @Override
    public boolean isTrapezoid(Quadrangle quadrangle) {
        if (!isConvex(quadrangle)) {
            logger.log(Level.INFO, quadrangle + " is not trapezoid");
            return false;
        }

        boolean firstPair = customMath.areLinesParallelOrPerpendicular(point1, point2, point3, point4, CustomMath.LinesType.PARALLEL);
        boolean secondPair = customMath.areLinesParallelOrPerpendicular(point2, point3, point1, point4, CustomMath.LinesType.PARALLEL);
        boolean result = firstPair || secondPair;

        logger.log(Level.INFO, quadrangle + " is trapezoid?: " + result);
        return result;
    }

    @Override
    public boolean isParallelogram(Quadrangle quadrangle) {
        if (!isTrapezoid(quadrangle)) {
            logger.log(Level.INFO, quadrangle + " is not parallelogram");
            return false;
        }

        boolean firstPair = customMath.areLinesParallelOrPerpendicular(point1, point2, point3, point4, CustomMath.LinesType.PARALLEL);
        boolean secondPair = customMath.areLinesParallelOrPerpendicular(point2, point3, point1, point4, CustomMath.LinesType.PARALLEL);
        boolean result = firstPair && secondPair;

        logger.log(Level.INFO, quadrangle + " is parallelogram?: " + result);
        return result;
    }

    @Override
    public boolean isRectangle(Quadrangle quadrangle) {
        if (!isParallelogram(quadrangle)) {
            logger.log(Level.INFO, quadrangle + " is not rectangle");
            return false;
        }

        double angle = customMath.calculateAngel(point1, point2, point3);
        double angle90 = 90;
        boolean result = angle == angle90;

        logger.log(Level.INFO, quadrangle + " is rectangle?: " + result);
        return result;
    }

    @Override
    public boolean isRhombus(Quadrangle quadrangle) {
        if (!isParallelogram(quadrangle)) {
            logger.log(Level.INFO, quadrangle + " is not rhombus");
            return false;
        }

        double firstSideLength = customMath.calculateLineBtwTwoPoints(point1, point2);
        double secondSideLength = customMath.calculateLineBtwTwoPoints(point2, point3);
        boolean result = firstSideLength == secondSideLength;

        logger.log(Level.INFO, quadrangle + " is rhombus?: " + result);
        return result;
    }

    @Override
    public boolean isSquare(Quadrangle quadrangle) {
        boolean result = isRhombus(quadrangle) && isRectangle(quadrangle);
        logger.log(Level.INFO, quadrangle + " is square?: " + result);
        return result;
    }
}
