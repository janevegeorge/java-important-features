package me.janeve.java8.interfaces.default_methods.multiple_inheritance_problem;

public class InterfaceImplementation implements Interface1, Interface2{
    @Override
    public void methodOne(String str) {
        System.out.println("Overridden methodOne: " + str);
    }

    // If the newMethod is not implemented, it would result in compile time error with message
    // Error: InterfaceImplementation inherits unrelated defaults for newMethod from types Interface1 and Interface2
    @Override
    public void newMethod() {
        System.out.println("InterfaceImplementation: Newly added method");
    }

    @Override
    public void methodTwo(String str) {
        System.out.println("Overridden methodTwo: " + str );
    }
}