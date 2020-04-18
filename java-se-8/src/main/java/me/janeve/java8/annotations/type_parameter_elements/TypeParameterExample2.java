package me.janeve.java8.annotations.type_parameter_elements;

import me.janeve.java8.annotations.AnInterface;
import me.janeve.java8.annotations.BaseClass;

// 2 - @GenericsTypeParameterAnnotation used to mark Generic Type declaration that extends another class
public class TypeParameterExample2<@GenericsTypeParameterAnnotation T extends BaseClass> implements AnInterface {

    private T genericType;

    public TypeParameterExample2(T genericType) {
        this.genericType = genericType;
    }

    @Override
    public void doSomething() {
        System.out.println(this.getClass().getName() + " - " + genericType.getClass().getName());
    }

}