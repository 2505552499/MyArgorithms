package com.company;

public class Leetcode66 {
    public static void main(String[] args) {
        int[] digits = {9,9};
        int[] arr = plusOne(digits);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
//            System.out.println(arr.length);
        }
    }

    public static int[] plusOne(int[] digits){
        int len = digits.length;
        while(len - 1 >= 0) {
            digits[len - 1] += 1;
            if (digits[len - 1] == 10) {
                digits[len - 1] = 0;
                len--;
            }else{
                return digits;
            }
        }
        if(digits[0] == 0){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;

    }
}
