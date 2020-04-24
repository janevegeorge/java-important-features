package me.janeve.java8.interfaces.default_methods.java8;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        runStringSorter();
        runIntegerSorter();
    }

    private static void runIntegerSorter() {
        SortableNumberCollection numberCollection = new SortableNumberCollection();

        Random randomNumberGenerator = new Random();
        numberCollection.add(randomNumberGenerator.nextInt(100));
        numberCollection.add(randomNumberGenerator.nextInt(100));
        numberCollection.add(randomNumberGenerator.nextInt(100));
        numberCollection.add(randomNumberGenerator.nextInt(100));
        numberCollection.add(randomNumberGenerator.nextInt(100));
        numberCollection.add(randomNumberGenerator.nextInt(100));

        System.out.println("First item: " + numberCollection.peek());
        System.out.println("First item (sorted): " + numberCollection.sortAndPeek());
    }

    private static void runStringSorter() {
        SortableStringCollection stringCollection = new SortableStringCollection();

        stringCollection.add("One");
        stringCollection.add("Two");
        stringCollection.add("Three");
        stringCollection.add("Four");
        stringCollection.add("Five");
        stringCollection.add("Six");

        System.out.println("First item: " + stringCollection.peek());
        System.out.println("First item (sorted): " + stringCollection.sortAndPeek());
    }

}