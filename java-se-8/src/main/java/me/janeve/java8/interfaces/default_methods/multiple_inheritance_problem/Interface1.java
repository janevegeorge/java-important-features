package me.janeve.java8.interfaces.default_methods.multiple_inheritance_problem;

public interface Interface1 {
    void methodOne(String str);
    default void newMethod(){
        System.out.println("Interface1: Newly added method");
    }
}