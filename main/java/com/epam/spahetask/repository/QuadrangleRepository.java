package com.epam.spahetask.repository;

import com.epam.spahetask.entity.Quadrangle;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public interface QuadrangleRepository {
    boolean add(Quadrangle quadrangle);

    boolean addAll(Collection<? extends Quadrangle> collection);

    void clear();

    boolean contains(Quadrangle quadrangle);

    boolean containsAll(Collection<? extends Quadrangle> collection);

    boolean isEmpty();

    Iterator<Quadrangle> iterator();

    boolean remove(Quadrangle quadrangle);

    boolean removeAll(Collection<? extends Quadrangle> collection);

    Collection<Quadrangle> sort(Comparator<? super Quadrangle> comparator);

    Collection<Quadrangle> query(Predicate<? super Quadrangle> predicate);
}
