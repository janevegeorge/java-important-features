package me.janeve.java5.autoboxing;

import java.util.ArrayList;
import java.util.List;

public class ArrayListWithWrapperClasses {

    public static void main(String[] args) {
        primitiveDataExample();
        primitiveDataRuntime();
        autoboxingData();
    }

    private static void autoboxingData() {
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
//         The lines below will throw compile time errors.
//        integerList.add(12.9);
//        integerList.add("Hello");

        System.out.println(integerList.size());
    }

    private static void primitiveDataExample() {
        List integerList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        integerList.add(12.9);
        integerList.add("Hello");

        System.out.println(integerList.size());
    }

    // This is an example of how the primitiveDataExample()
    // would execute at runtime. This is also an example of pre 1.5 code.
    private static void primitiveDataRuntime() {
        List<Object> integerList = new ArrayList<Object>();
        for (int i = 0; i < 10; i++) {
            integerList.add(Integer.valueOf(i));
        }
        integerList.add(Double.valueOf(12.9));
        integerList.add(String.valueOf("Hello"));

        System.out.println(integerList.size());
    }

}