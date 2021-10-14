package com.epam.spahetask.service;

import com.epam.spahetask.entity.CustomPoint;

public final class CustomMath {
    private CustomMath() {
    }

    public static boolean areLines(CustomPoint startFirstLine, CustomPoint endFirstLine,
                                   CustomPoint startSecondLine, CustomPoint endSecondLine, LinesType type) {
        boolean result;

        boolean firstLineVertical = isLineVertical(startFirstLine, endFirstLine);
        boolean firstLineHorizontal = isLineHorizontal(startFirstLine, endFirstLine);
        boolean secondLineVertical = isLineVertical(startSecondLine, endSecondLine);
        boolean secondLineHorizontal = isLineHorizontal(startSecondLine, endSecondLine);

        if ((firstLineHorizontal && secondLineHorizontal) || (firstLineVertical && secondLineVertical)) {
            result = type == LinesType.PARALLEL;
        } else if ((firstLineVertical && secondLineHorizontal) || (firstLineHorizontal && secondLineVertical)) {
            result = type == LinesType.PERPENDICULAR;
        } else {
            double partOne = calculateSlope(startFirstLine, endFirstLine);
            double partTwo = calculateSlope(startSecondLine, endSecondLine);
            result = partOne == type.n * partTwo;
        }

        return result;
    }

    public static boolean isLineVertical(CustomPoint startLine, CustomPoint endLine) {
        return 0 == startLine.getX() - endLine.getX();
    }

    public static boolean isLineHorizontal(CustomPoint startLine, CustomPoint endLine) {
        return 0 == startLine.getY() - endLine.getY();
    }

    public static double calculateLineBtwTwoPoints(CustomPoint point1, CustomPoint point2) {
        double dx = point2.getX() - point1.getX();
        double dy = point2.getY() - point1.getY();

        return Math.hypot(dx, dy);
    }

    public static double calculateSlope(CustomPoint point1, CustomPoint point2) {
        double dy = point2.getY() - point1.getY();
        double dx = point2.getX() - point1.getX();

        return dy / dx;
    }

    public static double calculateAngel(CustomPoint point1, CustomPoint point2, CustomPoint point3) {
        int P1Y = point2.getY();
        int P2Y = point1.getY();
        int P3Y = point3.getY();
        int P1X = point2.getX();
        int P2X = point1.getX();
        int P3X = point3.getX();

        double numerator = P2Y * (P1X - P3X) + P1Y * (P3X - P2X) + P3Y * (P2X - P1X);
        double denominator = (P2X - P1X) * (P1X - P3X) + (P2Y - P1Y) * (P1Y - P3Y);
        double ratio = numerator / denominator;

        double angleRad = Math.atan(ratio);
        double angleDeg = (angleRad * 180) / Math.PI;

        if (angleDeg < 0) {
            angleDeg = 180 + angleDeg;
        }

        return angleDeg;
    }

    public enum LinesType {
        PARALLEL(1),
        PERPENDICULAR(-1);

        private final int n;

        LinesType(int n) {
            this.n = n;
        }
    }
}
