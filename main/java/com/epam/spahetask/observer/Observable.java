package com.epam.spahetask.observer;

public interface Observable {
    void attach(QuadrangleObserver observer);

    void detach(QuadrangleObserver observer);

    void notifyObservers();
}
