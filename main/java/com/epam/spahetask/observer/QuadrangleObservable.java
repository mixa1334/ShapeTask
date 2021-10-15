package com.epam.spahetask.observer;

public interface QuadrangleObservable {
    void attach(QuadrangleObserver observer);

    void detach(QuadrangleObserver observer);

    void notifyObservers();
}
