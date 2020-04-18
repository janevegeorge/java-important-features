package me.janeve.java8.annotations.type_use_elements;

import me.janeve.java8.annotations.AnInterface;

// 1 - @GenericsTypeUseAnnotation used to mark Generic Type declaration
public class TypeUseExample1<@GenericsTypeUseAnnotation T> implements AnInterface {

    // 2 - @GenericsTypeUseAnnotation used to mark fields
    @GenericsTypeUseAnnotation private T genericType;

    // 3 - @GenericsTypeUseAnnotation used to mark fields
    public TypeUseExample1(@GenericsTypeUseAnnotation T genericType) {
        this.genericType = genericType;
    }

    @Override
    public void doSomething() {
        System.out.println(this.getClass().getName() + " - " + genericType.getClass().getName());
    }

}