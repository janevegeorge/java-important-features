package me.janeve.java8.annotations.type_use_elements;

import me.janeve.java8.annotations.AnInterface;
import me.janeve.java8.annotations.TestA;
import me.janeve.java8.annotations.TestB;
import me.janeve.java8.annotations.type_parameter_elements.TypeParameterExample1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TestA a = new TestA();
        TestB b = new TestB();

        TypeParameterExample1<TestA> a_example = new TypeParameterExample1<>(a);
        TypeUseExample1<TestB> b_example = new TypeUseExample1<>(b);

        List<AnInterface> list = Arrays.asList(a_example, b_example);

        for(AnInterface item: list) {
            item.doSomething();
        }

        // 4 - @GenericsTypeUseAnnotation used to mark arrays
        @GenericsTypeUseAnnotation char[] chars;

        // 5 - @GenericsTypeUseAnnotation used when creating objects
        List<String> arrayList = new @GenericsTypeUseAnnotation ArrayList<>();
    }

}