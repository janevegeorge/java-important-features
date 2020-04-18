package me.janeve.java8.annotations.type_parameter_elements;

import me.janeve.java8.annotations.AnInterface;
import me.janeve.java8.annotations.TestA;
import me.janeve.java8.annotations.TestB;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TestA a = new TestA();
        TestB b = new TestB();

        TypeParameterExample1<TestA> objA = new TypeParameterExample1<>(a);
        TypeParameterExample1<TestB> objB = new TypeParameterExample1<>(b);

        TypeParameterExample2<TestA> subObjA = new TypeParameterExample2<>(a);
        TypeParameterExample2<TestB> subObjB = new TypeParameterExample2<>(b);

        List<AnInterface> list = Arrays.asList(objA, objB, subObjA, subObjB);

        for(AnInterface item: list) {
            item.doSomething();
        }
    }

}