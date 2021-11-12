package com.jiaxin.test;

import com.jiaxin.linear.Stack;

public class StackTest {
    public static void main(String[] args) {
        //创建栈对象
        Stack<String> stack = new Stack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.pop();

        for (String item : stack) {
            System.out.println(item);
        }
        System.out.println("------------------------");
        String result = stack.pop();
        System.out.println("弹出的元素是：" + result);
        System.out.println("剩余元素的个数：" + stack.size());
    }
}
