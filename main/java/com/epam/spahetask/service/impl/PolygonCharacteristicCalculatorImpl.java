package com.epam.spahetask.service.impl;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;

import java.util.List;

//todo
public class PolygonCharacteristicCalculatorImpl implements Polygon {
    @Override
    public List<CustomPoint> getPoints() {
        return null;
    }

    @Override
    public void setPoints(List<CustomPoint> points) throws ShapeException {

    }

    @Override
    public long getPolygonId() {
        return 0;
    }
}
