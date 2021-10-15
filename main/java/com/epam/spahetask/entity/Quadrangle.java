package com.epam.spahetask.entity;


import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.factory.PointFactory;
import com.epam.spahetask.observer.Impl.QuadrangleEventImpl;
import com.epam.spahetask.observer.QuadrangleEvent;
import com.epam.spahetask.observer.QuadrangleObservable;
import com.epam.spahetask.observer.QuadrangleObserver;
import com.epam.spahetask.util.idgenerator.IdGenerator;
import com.epam.spahetask.service.impl.QuadrangleTypeCheckerImpl;

import java.util.ArrayList;
import java.util.List;

public class Quadrangle implements QuadrangleObservable {
    private final List<QuadrangleObserver> observers;
    private final long quadrangleId;
    private List<CustomPoint> customPoints;

    public Quadrangle() {
        observers = new ArrayList<>(1);
        quadrangleId = IdGenerator.generateId();
        PointFactory factory = PointFactory.INSTANCE;
        CustomPoint point1 = factory.createPoint(1, 1);
        CustomPoint point2 = factory.createPoint(1, 3);
        CustomPoint point3 = factory.createPoint(4, 3);
        CustomPoint point4 = factory.createPoint(4, 1);
        customPoints = List.of(point1, point2, point3, point4);
    }


    public List<CustomPoint> getAllPoints() {
        return PointFactory.INSTANCE.copyPoints(customPoints);
    }


    public void setPoints(List<CustomPoint> points) throws ShapeException {
        if (!QuadrangleTypeCheckerImpl.getInstance().isQuadrangle(points)) {
            throw new ShapeException("invalid data - " + points);
        }

        customPoints = PointFactory.INSTANCE.copyPoints(points);
    }


    public long getPolygonId() {
        return quadrangleId;
    }

    @Override
    public void attach(QuadrangleObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(QuadrangleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (QuadrangleObserver observer : observers) {
            QuadrangleEvent e = new QuadrangleEventImpl(this);
            observer.update(e);
        }
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