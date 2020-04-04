package me.janeve.java5.autoboxing;

// Example of Autoboxing
// in Java 5.0
class AutoboxingExamples
{
    public static void main(String[] args) {
        // primitive data types
        byte primitiveByte = 1;
        int primitiveInt = 10;
        float primitiveFloat = 18.6f;
        double primitiveDouble = 250.5;
        char primitiveChar = 'a';

        // Simple wrapped object example.
        Byte wrappedByte = new Byte(primitiveByte);
        Integer wrappedInteger = new Integer(primitiveInt);
        Float wrappedFloat = new Float(primitiveFloat);
        Double wrappedDouble = new Double(primitiveDouble);
        Character wrappedChar = new Character(primitiveChar);

        // Autoboxing Examples
        Byte autoboxingByte = primitiveByte;
        Integer autoboxingInteger = primitiveInt;
        Float autoboxingFloat = primitiveFloat;
        Double autoboxingDouble = primitiveDouble;
        Character autoboxingChar = primitiveChar;
    }
}