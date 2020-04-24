package me.janeve.java8.interfaces.default_methods.multiple_inheritance_problem;

public interface Interface2 {
    void methodTwo(String str);
    default void newMethod(){
        System.out.println("Interface2: Newly added method");
    }
}