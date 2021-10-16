package com.epam.spahetask.repository.impl;

import com.epam.spahetask.comparator.impl.IdComparator;
import com.epam.spahetask.entity.CustomPoint;
import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.factory.QuadrangleFactory;
import com.epam.spahetask.factory.impl.QuadrangleFactoryImpl;
import com.epam.spahetask.repository.QuadrangleRepository;
import com.epam.spahetask.service.QuadrangleCharacteristicCalculator;
import com.epam.spahetask.service.impl.QuadrangleCharacteristicCalculatorImpl;
import com.epam.spahetask.warehouse.QuadrangleParameter;
import com.epam.spahetask.warehouse.Warehouse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class QuadrangleRepositoryImplTest {
    PointFactory pointFactory;
    QuadrangleFactory quadrangleFactory;
    Warehouse warehouse;
    QuadrangleRepository quadrangleRepository;
    QuadrangleCharacteristicCalculator calculator;
    Quadrangle square;
    Quadrangle rectangle;
    Quadrangle quadrangle;

    @BeforeClass

    public void setUp() throws ShapeException {
        calculator = QuadrangleCharacteristicCalculatorImpl.getInstance();
        pointFactory = PointFactory.INSTANCE;
        quadrangleFactory = QuadrangleFactoryImpl.INSTANCE;
        warehouse = Warehouse.getInstance();
        quadrangleRepository = QuadrangleRepositoryImpl.getInstance();

        List<CustomPoint> squareP = List.of(pointFactory.createPoint(1, 1), pointFactory.createPoint(1, 4)
                , pointFactory.createPoint(4, 4), pointFactory.createPoint(4, 1));
        square = quadrangleFactory.createPolygon(squareP);

        List<CustomPoint> rectangleP = List.of(pointFactory.createPoint(1, 1), pointFactory.createPoint(1, 3)
                , pointFactory.createPoint(9, 3), pointFactory.createPoint(9, 1));
        rectangle = quadrangleFactory.createPolygon(rectangleP);

        List<CustomPoint> quadrangleP = List.of(pointFactory.createPoint(1, 1), pointFactory.createPoint(1, 6)
                , pointFactory.createPoint(8, 9), pointFactory.createPoint(8, 1));
        quadrangle = quadrangleFactory.createPolygon(quadrangleP);

        warehouse.put(square.getQuadrangleId(), new QuadrangleParameter(calculator.calculateArea(square).get()
                , calculator.calculatePerimeter(square).get()));

        warehouse.put(rectangle.getQuadrangleId(), new QuadrangleParameter(calculator.calculateArea(rectangle).get()
                , calculator.calculatePerimeter(rectangle).get()));

        warehouse.put(quadrangle.getQuadrangleId(), new QuadrangleParameter(calculator.calculateArea(quadrangle).get()
                , calculator.calculatePerimeter(quadrangle).get()));

        quadrangleRepository.add(quadrangle);
        quadrangleRepository.add(rectangle);
        quadrangleRepository.add(square);
    }

    @Test
    public void testSort() {
        List<Quadrangle> expected = List.of(square, rectangle, quadrangle);
        List<Quadrangle> actual = quadrangleRepository.sort(new IdComparator()).stream().collect(Collectors.toList());

        assertEquals(actual, expected);
    }

    @Test
    public void testQuery() {
        Object[] expected = new Object[]{square, rectangle};
        Object[] actual = quadrangleRepository.query(new RectangleSpecification()).toArray();

        assertEqualsNoOrder(actual, expected);
    }
}