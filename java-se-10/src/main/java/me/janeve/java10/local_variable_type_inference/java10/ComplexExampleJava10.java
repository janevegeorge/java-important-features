package me.janeve.java10.local_variable_type_inference.java10;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ComplexExampleJava10 {

    static final Random randomGenerator = new Random();
    static final NumberFormat numberFormatter = NumberFormat.getIntegerInstance();

    public static void main(String[] args) {
        var list = new ArrayList<HashMap<String, Integer>>(); // inferred as ArrayList<HashMap<String, Integer>>

        for (int i = 1; i <= 50; i++) {
            list.add(getItem(i));
        }

        // Benefits of Local Variables Type Inference show below
        var stream = list.stream();         // inferred as Stream<HashMap<String, Integer>>
        var length = list.size();           // inferred as int
        var subList = list.subList(10, 20); // inferred as List<HashMap<String, Integer>>
        var map =  list.get(10);            // inferred as HashMap<String, Integer>
        var keys = map.keySet();            // inferred as Set<String>

        // Usages of local variables.
        Integer wrapperInteger = length;        // length is considered as int
        stream.forEach(System.out::println);    // forEach of Stream<HashMap<String, Integer>> invoked
        int subListSize = subList.size();       // size of List<HashMap<String, Integer>> invoked
        int noOfKeys = map.size();              // size of HashMap<String, Integer> invoked
        keys.add("New String");                 // add of Set<String> invoked
    }

    private static HashMap<String, Integer> getItem(int numOfElements) {
        HashMap<String, Integer> map = new HashMap<>(numOfElements);
        for (int i = 0; i < numOfElements; i++) {
            int number = randomGenerator.nextInt();
            map.put(numberFormatter.format(number), number);
        }
        return map;
    }

}