package me.janeve.java5.varargs;

public class BeforeJava5Example {

    public static void main(String[] args) {
        // Sum of two numbers - Calls int sum(int num1, int num2) method
        int sumOf2 = sum(2, 4);


        // Sum of two numbers - Calls int sum(int num1, int num2, int num3) method
        int sumOf3 = sum(2, 4, 5);


        // Sum of two numbers - Calls int sum(int ... nums) method
        int sumOf5 = sum(2, 4, 5, 10, 20);


        // Sum of two numbers - Calls int sum(int num1, int num2, int num3) method
        int[] intArr = {2, 4, 5, 7, 8, 9, 20};
        int sumArr = sumArr(intArr);
    }

    private static int sum(int num1, int num2, int num3, int num4, int num5) {
        return num1 + num2 + num3 + num4 + num5;
    }

    private static int sumArr(int[] intArr) {
        int sum = 0;
        for(int index = 0; index < intArr.length; index++) {
            sum += intArr[index];
        }
        return sum;
    }

    private static int sum(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    private static int sum(int num1, int num2) {
        return num1 + num2;
    }
}