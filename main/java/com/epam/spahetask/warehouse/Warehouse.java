package com.epam.spahetask.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private final Map<Long, QuadrangleParameter> quadrangles;

    private Warehouse() {
        quadrangles = new HashMap<>();
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public int size() {
        return quadrangles.size();
    }

    public Optional<QuadrangleParameter> get(Long key) {
        return Optional.ofNullable(quadrangles.get(key));
    }

    public Optional<QuadrangleParameter> put(Long key, QuadrangleParameter value) {
        return Optional.ofNullable(quadrangles.put(key, value));
    }

    public boolean update(Long key, QuadrangleParameter value) {
        if (!quadrangles.containsKey(key)) {
            return false;
        }

        QuadrangleParameter parameter = quadrangles.get(key);
        parameter.setArea(value.getArea());
        parameter.setPerimeter(value.getPerimeter());
        return true;
    }

    public Optional<QuadrangleParameter> remove(Long key) {
        return Optional.ofNullable(quadrangles.remove(key));
    }

    public void clear() {
        quadrangles.clear();
    }
}
