package me.janeve.java10.local_variable_type_inference.java10;

public class InvalidUseOfVarKeyword {

    // INVALID - It cannot be used for declaring class properties.
    /* var classProperty; */

    // INVALID - It cannot be used for declaring class properties.
    /* var dateProperty = new Date(); */


    public void aMethod(){
        // INVALID - It cannot be used for local variables without initialization.
        /* var localVariable; */


        // INVALID - It cannot be used for local variables which are initialized with null.
        /* var nullVariable = null; */


        // INVALID - It cannot be used with an array initializer without any explicit target-types.
        /* var arrayVariable  = {1, 2, 3}; */


        // The code below is valid since it has an explicit target-type int[]
        var intArrayVariable = new int[]{1, 2, 3};
    }


    // INVALID - It cannot be used for method parameter variables.
    public void aMethodWithParameters   (String param1 /*, var param2 */) { }

    // INVALID - It cannot be used for a method return type.
    /* public var aMethodWithReturnType{ return "Hello"; } */

}