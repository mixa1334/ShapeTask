package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.service.PolygonTypeChecker;

import java.util.List;

//todo
public class PolygonTypeCheckerImpl implements PolygonTypeChecker {
    @Override
    public boolean isConvex(Polygon polygon) {
        List<CustomPoint> points = polygon.getPoints();
        if (points.size() < 4) {
            return true;
        }

        boolean sign = false;
        int n = points.size();

        for (int i = 0; i < n; i++) {
            double dx1 = points.get((i + 2) % n).getX() - points.get((i + 1) % n).getX();
            double dy1 = points.get((i + 2) % n).getY() - points.get((i + 1) % n).getY();
            double dx2 = points.get(i).getX() - points.get((i + 1) % n).getX();
            double dy2 = points.get(i).getY() - points.get((i + 1) % n).getY();
            double angel = dx1 * dy2 - dy1 * dx2;

            if (i == 0) {
                sign = angel > 0;
            } else if (sign != (angel > 0)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isRectangle(Polygon polygon) {
        return false;
    }

    @Override
    public boolean isSquare(Polygon polygon) {
        return false;
    }

    @Override
    public boolean isRhombus(Polygon polygon) {
        return false;
    }

    @Override
    public boolean isTrapezoid(Polygon polygon) {
        return false;
    }
}
