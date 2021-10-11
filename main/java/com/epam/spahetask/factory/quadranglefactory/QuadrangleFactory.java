package com.epam.spahetask.factory.quadranglefactory;

import com.epam.spahetask.entity.point.CustomPoint;
import com.epam.spahetask.entity.polygon.Polygon;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PolygonFactory;
import com.epam.spahetask.validator.QuadrangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


// to-do
public class QuadrangleFactory implements PolygonFactory {
    final static Logger logger = LogManager.getLogger();

    @Override
    public Polygon createPolygon(CustomPoint... points) throws ShapeException {
        if (!QuadrangleValidator.isQuadrangle(points)) {
            throw new ShapeException(Arrays.toString(points) + " is not quadrangle");
        }


    }
}
