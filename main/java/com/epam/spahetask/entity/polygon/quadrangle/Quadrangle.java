package com.epam.spahetask.entity.polygon.quadrangle;

import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.idgenerator.IdGenerator;
import com.epam.spahetask.service.impl.QuadrangleTypeCheckerImpl;

import java.util.List;

public class Quadrangle extends Polygon {
    private List<CustomPoint> customPoints;
    private final long quadrangleId;

    public Quadrangle() {
        quadrangleId = IdGenerator.generateId();
        PointFactory factory = PointFactory.INSTANCE;
        CustomPoint point1 = factory.createPoint(1, 1);
        CustomPoint point2 = factory.createPoint(1, 3);
        CustomPoint point3 = factory.createPoint(4, 3);
        CustomPoint point4 = factory.createPoint(4, 1);
        customPoints = List.of(point1, point2, point3, point4);
    }

    @Override
    public List<CustomPoint> getAllPoints() {
        return PointFactory.INSTANCE.copyPoints(customPoints);
    }

    @Override
    public void setPoints(List<CustomPoint> points) throws ShapeException {
        if (!QuadrangleTypeCheckerImpl.getInstance().isQuadrangle(points)) {
            throw new ShapeException("invalid data - " + points);
        }

        customPoints = PointFactory.INSTANCE.copyPoints(points);
    }

    @Override
    public long getPolygonId() {
        return quadrangleId;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(quadrangleId) + customPoints.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Quadrangle quadrangle = (Quadrangle) obj;
        return quadrangle.quadrangleId == this.quadrangleId && quadrangle.customPoints == this.customPoints;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("[points=").append(customPoints).append(", quadrangleId=").append(quadrangleId).append("]");
        return message.toString();
    }
}
