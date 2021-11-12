package com.jiaxin.test;

import com.jiaxin.priority.MaxPriorityQueue;

public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        queue.insert("B");
        while(!queue.isempty()){
            String max = queue.delMax();
            System.out.println(max + " ");
        }

    }
}
