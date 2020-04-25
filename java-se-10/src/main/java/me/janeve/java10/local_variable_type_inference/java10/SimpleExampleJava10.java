package me.janeve.java10.local_variable_type_inference.java10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SimpleExampleJava10 {
    public static void main(String[] args) {
        //String variable
        var name = "Janeve George";

        // Initializing object
        var stringBuilder = new StringBuilder();
        var dateFormat = new SimpleDateFormat("dd/MM/yy");

        //Initialization with Generic types
        var list = new ArrayList<String>();
    }
}