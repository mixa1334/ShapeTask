package com.epam.spahetask.repository.impl;

import com.epam.spahetask.entity.Quadrangle;
import com.epam.spahetask.repository.QuadrangleRepository;

import java.util.*;
import java.util.function.Predicate;

public class QuadrangleRepositoryImpl implements QuadrangleRepository {
    private final static QuadrangleRepositoryImpl instance = new QuadrangleRepositoryImpl();

    private final Set<Quadrangle> quadrangleSet;

    private QuadrangleRepositoryImpl() {
        quadrangleSet = new HashSet<>();
    }

    public static QuadrangleRepositoryImpl getInstance() {
        return instance;
    }


    @Override
    public boolean add(Quadrangle quadrangle) {
        return quadrangleSet.add(quadrangle);
    }

    @Override
    public boolean addAll(Collection<? extends Quadrangle> collection) {
        return quadrangleSet.addAll(collection);
    }

    @Override
    public void clear() {
        quadrangleSet.clear();
    }

    @Override
    public boolean contains(Quadrangle quadrangle) {
        return quadrangleSet.contains(quadrangle);
    }

    @Override
    public boolean containsAll(Collection<? extends Quadrangle> collection) {
        return quadrangleSet.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return quadrangleSet.isEmpty();
    }

    @Override
    public Iterator<Quadrangle> iterator() {
        return quadrangleSet.iterator();
    }

    @Override
    public boolean remove(Quadrangle quadrangle) {
        return quadrangleSet.remove(quadrangle);
    }

    @Override
    public boolean removeAll(Collection<? extends Quadrangle> collection) {
        return quadrangleSet.removeAll(collection);
    }

    @Override
    public Collection<Quadrangle> sort(Comparator<? super Quadrangle> comparator) {
        return quadrangleSet.stream().sorted(comparator).toList();
    }

    @Override
    public Collection<Quadrangle> query(Predicate<? super Quadrangle> predicate) {
        return quadrangleSet.stream().filter(predicate).toList();
    }
}
