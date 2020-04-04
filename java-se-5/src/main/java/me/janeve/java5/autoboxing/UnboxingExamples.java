package me.janeve.java5.autoboxing;

// Example of Unboxing
// in Java 5.0
public class UnboxingExamples {

    public static void main(String[] args) {
        // Creating objects using wrapper classes and autoboxing
        Byte autoboxingByte = 1;
        Integer autoboxingInteger = 10;
        Float autoboxingFloat = 18.6f;
        Double autoboxingDouble = 250.5;
        Character autoboxingChar = 'a';

        // Unboxing to primitive data types.
        byte primitiveByte = autoboxingByte;
        int primitiveInt = autoboxingInteger;
        float primitiveFloat = autoboxingFloat;
        double primitiveDouble = autoboxingDouble;
        char primitiveChar = autoboxingChar;
    }

}