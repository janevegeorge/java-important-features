package me.janeve.java5.varargs;

/**
 * Java varargs feature allows to create methods for which you are not sure
 * how many arguments your method needs to accept. A method that takes
 * variable number of arguments is called a variable-arity method, or
 * simply a varargs method.
 */
public class Java5Example {

    public static void main(String[] args) {
        // Sum of two numbers - Calls int sum(int ... nums) method
        int sumOf2 = sum(2, 4);


        // Sum of two numbers - Calls int sum(int ... nums) method
        int sumOf3 = sum(2, 4, 5);


        // Sum of two numbers - Calls int sum(int ... nums) method
        int sumOf5 = sum(2, 4, 5, 10, 20);


        // Sum of two numbers - Calls int sum(int ... nums) method
        int[] intArr = {2, 4, 5, 7, 8, 9, 20};
        int sumArr = sum(intArr);
    }

    private static int sum(int ... nums) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        return sum;
    }

}