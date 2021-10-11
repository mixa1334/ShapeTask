package com.epam.spahetask.factory;

import com.epam.spahetask.entity.point.CustomPoint;

public final class PointFactory {
    public static CustomPoint createPoint(int x, int y){
        CustomPoint point = new CustomPoint();
        point.setX(x);
        point.setY(y);
        return point;
    }

    public static CustomPoint createPoint(CustomPoint point){
        CustomPoint newPoint = new CustomPoint();
        point.setX(point.getX());
        point.setY(point.getY());
        return point;
    }
}
