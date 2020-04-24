package me.janeve.java8.interfaces.default_methods.before_java8;

import java.util.Comparator;

public class ObjectComparator implements Comparator<Comparable> {

    @Override
    public int compare(Comparable o1, Comparable o2) {
        return o1.compareTo(o2);
    }
}