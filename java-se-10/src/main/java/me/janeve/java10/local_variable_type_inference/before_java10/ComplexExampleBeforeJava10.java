package me.janeve.java10.local_variable_type_inference.before_java10;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class ComplexExampleBeforeJava10 {

    static final Random randomGenerator = new Random();
    static final NumberFormat numberFormatter = NumberFormat.getIntegerInstance();

    public static void main(String[] args) {
        List<HashMap<String, Integer>> list = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            list.add(getItem(i));
        }

        Stream<HashMap<String, Integer>> stream = list.stream();
        int length = list.size();
        List<HashMap<String, Integer>> subList = list.subList(10, 20);
        HashMap<String, Integer> map =  list.get(10);
        Set<String> keys = map.keySet();

        // Usages of local variables.
        Integer wrapperInteger = length;
        stream.forEach(System.out::println);
        int subListSize = subList.size();
        int noOfKeys = map.size();
        keys.add("New String");
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