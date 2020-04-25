package me.janeve.java10.local_variable_type_inference.before_java10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SimpleExampleBeforeJava10 {

    public static void main(String[] args) {
        //String variable
        String name = "Janeve George";

        // Initializing object
        StringBuilder stringBuilder = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        //Initialization with Generic types
        List<String> list = new ArrayList<>();
    }
}
