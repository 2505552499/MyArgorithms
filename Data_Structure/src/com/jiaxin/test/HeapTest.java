package com.jiaxin.test;

import com.jiaxin.Heap.Heap;
import com.jiaxin.linear.Queue;
public class HeapTest {
    public static void main(String[] args) {
        Heap<String> hp = new Heap<>(10);
        hp.insert("A");
        hp.insert("B");
        hp.insert("C");
        hp.insert("D");
        hp.insert("E");
        hp.insert("F");
        hp.insert("G");

        String result = null;
        while ((result = hp.delMax()) != null) {
            System.out.print(result + " ");
        }
    }
}
