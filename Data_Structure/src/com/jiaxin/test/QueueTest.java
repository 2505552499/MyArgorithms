package com.jiaxin.test;

import com.jiaxin.linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new Queue();
        q.enqueuq("a");
        q.enqueuq("b");
        q.enqueuq("c");
        q.enqueuq("d");
        for (String s : q) {
            System.out.println(s);
        }
        System.out.println("-------------------");
        String result = q.dequeue();
        System.out.println("出队列的元素是：" + result);
        System.out.println("剩余元素个数是：" + q.size());

    }
}
