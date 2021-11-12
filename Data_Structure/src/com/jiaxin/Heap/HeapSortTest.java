package com.jiaxin.Heap;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数组
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
