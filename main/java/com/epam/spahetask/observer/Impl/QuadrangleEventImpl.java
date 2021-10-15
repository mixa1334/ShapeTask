package com.epam.spahetask.observer.Impl;

import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.observer.QuadrangleEvent;

public class QuadrangleEventImpl implements QuadrangleEvent {
    private final Quadrangle quadrangle;

    public QuadrangleEventImpl(Quadrangle quadrangle) {
        this.quadrangle = quadrangle;
    }

    @Override
    public Quadrangle getSource() {
        return quadrangle;
    }
}
