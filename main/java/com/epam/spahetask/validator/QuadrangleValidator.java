package com.epam.spahetask.validator;

import com.epam.spahetask.entity.point.CustomPoint;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public final class QuadrangleValidator {
    final static Logger logger = LogManager.getLogger();

    public static boolean isQuadrangle(CustomPoint... point) {
        if (point.length != 4) {
            logger.log(Level.INFO, Arrays.toString(point) + " is not quadrangle");
            return false;
        }
        if (point[0] == null || point[1] == null || point[2] == null || point[3] == null) {
            logger.log(Level.INFO, Arrays.toString(point) + " is not quadrangle");
            return false;
        }

        boolean firstTrio = isLine(point[0], point[1], point[2]);
        boolean secondTrio = isLine(point[0], point[1], point[3]);
        boolean thirdTrio = isLine(point[0], point[2], point[3]);
        boolean fourthTrio = isLine(point[1], point[2], point[3]);

        boolean result = !(firstTrio || secondTrio || thirdTrio || fourthTrio);
        logger.log(Level.INFO, Arrays.toString(point) + " isQuadrangle?: " + result);
        return result;
    }

    private static boolean isLine(CustomPoint point1, CustomPoint point2, CustomPoint point3) {
        int firstSlope = (point1.getY() - point2.getY()) * (point1.getX() - point3.getX());
        int secondSlope = (point1.getY() - point3.getY()) * (point1.getX() - point2.getX());
        return firstSlope == secondSlope;
    }
}
