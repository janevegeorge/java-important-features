package me.janeve.java8.interfaces.default_methods.before_java8;

public interface Sortable<T> {

    void sort();
    T peek();

    // New method added.
    T sortAndPeek();

}