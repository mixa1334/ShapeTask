package com.epam.spahetask.observer.Impl;

import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.observer.QuadrangleEvent;

public record QuadrangleEventImpl(Quadrangle quadrangle) implements QuadrangleEvent {
    @Override
    public Quadrangle getSource() {
        return quadrangle;
    }
}
