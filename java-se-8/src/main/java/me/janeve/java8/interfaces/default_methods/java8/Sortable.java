package me.janeve.java8.interfaces.default_methods.java8;

public interface Sortable<T> {

    Direction defaultDirection = Direction.DESC;

    enum Direction {
        ASC,
        DESC
    };

    void sort();
    T peek();

    default T sortAndPeek(){
        sort();
        return peek();
    }

    static Direction getDefaultDirection(){
        return defaultDirection;
    }
}