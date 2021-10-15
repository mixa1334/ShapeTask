package com.epam.spahetask.factory;

import com.epam.spahetask.entity.CustomPoint;

import java.util.List;
import java.util.stream.Collectors;

public enum PointFactory {
    INSTANCE;

    public CustomPoint createPoint(int x, int y) {
        CustomPoint point = new CustomPoint();
        point.setX(x);
        point.setY(y);
        return point;
    }

    public CustomPoint createPoint(CustomPoint point) {
        CustomPoint newPoint = new CustomPoint();
        newPoint.setX(point.getX());
        newPoint.setY(point.getY());
        return newPoint;
    }

    public List<CustomPoint> copyPoints(List<CustomPoint> points) {
        return points.stream()
                .map(this::createPoint)
                .collect(Collectors.toList());
    }
}
