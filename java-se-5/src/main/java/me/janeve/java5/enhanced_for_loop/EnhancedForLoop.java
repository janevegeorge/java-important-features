package me.janeve.java5.enhanced_for_loop;

import java.util.*;

/**
 * This class provides few examples of how to use the enhanced for loop in Java 5.
 * This class also provide some advantages of using Generics and Type checking
 * that was introduced in Java 5.
 */
public class EnhancedForLoop {

    public static void main(String[] args) {
        pre_java5_arrays();
        post_java5_arrays();

        pre_java5_list();
        post_java5_list();

        pre_java5_map();
        post_java5_map();
    }

    /*
    This method provides an example of how for loops are used to iterate over
    items within a HashMap after Java 5.
    */
    private static void post_java5_map() {
        System.out.println("   Post Java 5 (Map)   ");
        System.out.println("=======================");
        Map<Integer, String> map = new HashMap<Integer, String>();

        // Inserting random numbers into map.
        for(int index= 0; index < 10; index++) {
            Integer value = new Random().nextInt();
            map.put(value, String.valueOf(value));
        }

        // Printing the entries in the map
        System.out.println("Values in the map:");
        for(Map.Entry<Integer, String> entry:map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /*
    This method provides an example of how for loops are used to iterate over
    items within a HashMap before Java 5.
    */
    private static void pre_java5_map() {
        System.out.println("   Pre Java 5 (Map)   ");
        System.out.println("======================");
        Map map = new HashMap();

        // Inserting random numbers into map.
        for(int index= 0; index < 10; index++) {
            Integer value = new Random().nextInt();
            map.put(value, String.valueOf(value));
        }

        // Printing the entries in the map
        System.out.println("Values in the map:");
        Iterator keyIterator = map.keySet().iterator();
        for(; keyIterator.hasNext(); ) {
            Integer value = (Integer) keyIterator.next();
            System.out.println(value + ":" + map.get(value));
        }
    }

    /*
    This method provides an example of how for loops are used to iterate over
    items within a ArrayList after Java 5.
    */
    private static void post_java5_list() {
        System.out.println("   Post Java 5 (Lists)   ");
        System.out.println("=========================");
        List<Integer> list = new ArrayList<Integer>();

        // Inserting random numbers into the list.
        for(int index= 0; index < 10; index++) {
            list.add(new Random().nextInt());
        }

        // Printing the Integer numbers in the list
        System.out.println("Values in the list:");
        for(Integer value:list ) {
            System.out.println(value);
        }
    }

    /*
    This method provides an example of how for loops are used to iterate over
    items within a ArrayList before Java 5.
    */
    private static void pre_java5_list() {
        System.out.println("   Pre Java 5 (Lists)   ");
        System.out.println("========================");
        List list = new ArrayList();

        // Inserting random numbers into the list.
        for(int index= 0; index < 10; index++) {
            list.add(Integer.valueOf(new Random().nextInt()));
        }

        // Printing the Integer numbers in the list
        System.out.println("Values in the list:");
        Iterator listIterator = list.iterator();
        for(; listIterator.hasNext(); ) {
            Integer value = (Integer) listIterator.next();
            System.out.println(value);
        }
    }

    /*
    This method provides an example of how for loops are used to iterate over
    items within an array after Java 5.
    */
    private static void post_java5_arrays() {
        System.out.println("   Post Java 5 (Arrays)   ");
        System.out.println("==========================");
        int[] intArr = new int[10];

        // Inserting random numbers into intArr[index].
        for(int index= 0; index < intArr.length; index++) {
            intArr[index] = new Random().nextInt();
        }

        // Printing the int numbers in the intArr
        System.out.println("Values in the array:");
        for(int value : intArr) { // Enhanced For loop. Iterating through each item in the array
            System.out.println(value);
        }
    }

    /*
    This method provides an example of how for loops are used to iterate over
    items within an array before Java 5.
    */
    private static void pre_java5_arrays() {
        System.out.println("   Pre Java 5 (Arrays)   ");
        System.out.println("=========================");
        int[] intArr = new int[10];

        // Inserting random numbers into intArr[index].
        for(int index= 0; index < intArr.length; index++) {
            intArr[index] = new Random().nextInt();
        }

        // Printing the int numbers in the intArr
        System.out.println("Values in the array:");
        for(int index= 0; index < intArr.length; index++) {
            System.out.println(intArr[index]);
        }
    }

}