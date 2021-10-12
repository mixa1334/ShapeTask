package com.epam.spahetask.factory.quadranglefactory;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.entity.polygon.quadrangle.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PolygonFactory;
import com.epam.spahetask.validator.QuadrangleValidator;

import java.util.List;

public class QuadrangleFactory implements PolygonFactory {

    @Override
    public Polygon createPolygon(List<CustomPoint> points) throws ShapeException {
        if (!QuadrangleValidator.isQuadrangle(points)) {
            throw new ShapeException(points + " is not quadrangle");
        }

        Polygon polygon = new Quadrangle();
        polygon.setPoints(points);

        return polygon;
    }
}
