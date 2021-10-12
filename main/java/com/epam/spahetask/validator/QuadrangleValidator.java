package com.epam.spahetask.validator;

import com.epam.spahetask.entity.point.CustomPoint;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class QuadrangleValidator {
    final static Logger logger = LogManager.getLogger();

    public static boolean isQuadrangle(List<CustomPoint> points) {
        if (points == null || points.size() != 4) {
            logger.log(Level.INFO, points + " is not quadrangle");
            return false;
        }

        CustomPoint point1 = points.get(0);
        CustomPoint point2 = points.get(1);
        CustomPoint point3 = points.get(2);
        CustomPoint point4 = points.get(3);

        if (point1 == null || point2 == null || point3 == null || point4 == null) {
            logger.log(Level.INFO, points + " is not quadrangle");
            return false;
        }

        boolean firstTrio = isLine(point1, point2, point3);
        boolean secondTrio = isLine(point1, point2, point4);
        boolean thirdTrio = isLine(point1, point3, point4);
        boolean fourthTrio = isLine(point2, point3, point4);

        boolean result = !(firstTrio || secondTrio || thirdTrio || fourthTrio);
        logger.log(Level.INFO, points + " isQuadrangle?: " + result);
        return result;
    }

    private static boolean isLine(CustomPoint point1, CustomPoint point2, CustomPoint point3) {
        int firstSlope = (point1.getY() - point2.getY()) * (point1.getX() - point3.getX());
        int secondSlope = (point1.getY() - point3.getY()) * (point1.getX() - point2.getX());
        return firstSlope == secondSlope;
    }
}
