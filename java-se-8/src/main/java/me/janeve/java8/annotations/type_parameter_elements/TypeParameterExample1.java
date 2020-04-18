package me.janeve.java8.annotations.type_parameter_elements;

import me.janeve.java8.annotations.AnInterface;

// 1 - @GenericsTypeParameterAnnotation used to mark Generic Type declaration
public class TypeParameterExample1<@GenericsTypeParameterAnnotation T> implements AnInterface {

    private T genericType;

    public TypeParameterExample1(T genericType) {
        this.genericType = genericType;
    }

    @Override
    public void doSomething() {
        System.out.println(this.getClass().getName() + " - " + genericType.getClass().getName());
    }

}