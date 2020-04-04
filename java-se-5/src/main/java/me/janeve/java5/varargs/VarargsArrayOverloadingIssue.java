package me.janeve.java5.varargs;

public class VarargsArrayOverloadingIssue {

    public static void main(String[] args) {
//        The following statement will not compile since the method does not accept varargs and there is no
//        Method with a matching signature.
        /* int sumOf3 = sumOfNums(2, 4, 5); */

        // Sum of two numbers - Calls int sum(int ... nums) method
        int[] intArr = {2, 4, 5, 7, 8, 9, 10, 15, 20};
        int sum = sumOfNums(intArr);
    }

    private static int sumOfNums(int[] nums) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        return sum;
    }

    // The following method will not compile when there is an
    // Overloaded int sumOfNums(int[] nums) method.
    /*
    private static int sumOfNums(int ... nums) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        return sum;
    }*/
}
