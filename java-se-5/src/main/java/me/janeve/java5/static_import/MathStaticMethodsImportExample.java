package me.janeve.java5.static_import;

/*
    The following line is to import the static methods and properties in java.lang.Math class.
    By doing so, we will be able to directly call these static methods and properties without any references.
*/
import static java.lang.Math.*;

/**
 * This file provide an example of how we can import static methods since Java 5.
 */
public class MathStaticMethodsImportExample {

    public static void main(String[] args) {
        // Examples of calling static methods with the need for a reference.
        System.out.println("CEILING(24.56): " + ceil(24.56)); // Calls Math.ceil(double a) method
        System.out.println("CEILING(24.23): " + ceil(24.23));

        System.out.println("ROUND(24.56): " + round(24.56)); // Calls Math.round(double a) method
        System.out.println("ROUND(24.23): " + round(24.23));

        System.out.println("FLOOR(24.56): " + floor(24.56)); // Calls Math.floor(double a) method
        System.out.println("FLOOR(24.23): " + floor(24.23));


        // Examples of using static attributes with the need for a reference.
        System.out.println("PI: " + PI);    // Uses Math.PI (the ratio of the circumference of a circle to its diameter) attribute
        System.out.println("E: " + E);      // Uses Math.E (the base of the natural logarithms) attribute
    }

}