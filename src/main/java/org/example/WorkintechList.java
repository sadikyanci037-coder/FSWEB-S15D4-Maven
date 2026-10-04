package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WorkintechList<T extends Comparable<? super T>>
        extends ArrayList<T> {

    @Override
    public boolean add(T element) {

        if (contains(element)) {
            return false;
        }

        return super.add(element);
    }

    @Override
    public void add(int index, T element) {

        if (!contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {

        boolean changed = false;

        for (T element : collection) {

            if (add(element)) {
                changed = true;
            }
        }

        return changed;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {

        boolean changed = false;

        for (T element : collection) {

            if (!contains(element)) {
                super.add(index, element);
                index++;
                changed = true;
            }
        }

        return changed;
    }

    @Override
    public T set(int index, T element) {

        if (contains(element) && !get(index).equals(element)) {
            return get(index);
        }

        return super.set(index, element);
    }

    public void sort() {
        Collections.sort(this);
    }

    @Override
    public boolean remove(Object object) {

        boolean removed = super.remove(object);

        sort();

        return removed;
    }
}