package com.epam.spahetask.factory;

import com.epam.spahetask.entity.point.CustomPoint;

import java.util.List;
import java.util.stream.Collectors;

public final class PointFactory {
    private PointFactory() {
    }

    public static CustomPoint createPoint(int x, int y) {
        CustomPoint point = new CustomPoint();
        point.setX(x);
        point.setY(y);
        return point;
    }

    public static CustomPoint createPoint(CustomPoint point) {
        CustomPoint newPoint = new CustomPoint();
        newPoint.setX(point.getX());
        newPoint.setY(point.getY());
        return newPoint;
    }

    public static List<CustomPoint> copyPoints(List<CustomPoint> points) {
        return points.stream()
                .map(PointFactory::createPoint)
                .collect(Collectors.toList());
    }
}
