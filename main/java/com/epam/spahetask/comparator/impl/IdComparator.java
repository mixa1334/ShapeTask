package com.epam.spahetask.comparator.impl;

import com.epam.spahetask.comparator.QuadrangleComparator;
import com.epam.spahetask.entity.Quadrangle;

public class IdComparator implements QuadrangleComparator {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        return Long.compare(o1.getQuadrangleId(), o2.getQuadrangleId());
    }
}
