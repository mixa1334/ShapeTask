package com.epam.spahetask.entity.polygon.quadrangle;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.idgenerator.IdGenerator;
import com.epam.spahetask.validator.QuadrangleValidator;

import java.util.List;

public class Quadrangle implements Polygon {
    private List<CustomPoint> customPoints;
    private final long quadrangleId;

    public Quadrangle() {
        quadrangleId = IdGenerator.generateId();
        CustomPoint point1 = PointFactory.createPoint(1, 1);
        CustomPoint point2 = PointFactory.createPoint(1, 3);
        CustomPoint point3 = PointFactory.createPoint(4, 3);
        CustomPoint point4 = PointFactory.createPoint(4, 1);
        customPoints = List.of(point1, point2, point3, point4);
    }

    @Override
    public List<CustomPoint> getPoints() {
        return PointFactory.copyPoints(customPoints);
    }

    @Override
    public void setPoints(List<CustomPoint> points) throws ShapeException {
        if (!QuadrangleValidator.isQuadrangle(points)) {
            throw new ShapeException("invalid data - " + points);
        }

        customPoints = PointFactory.copyPoints(points);
    }

    @Override
    public long getPolygonId() {
        return quadrangleId;
    }
}
