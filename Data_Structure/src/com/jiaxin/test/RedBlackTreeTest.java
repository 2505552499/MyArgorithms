package com.jiaxin.test;

import com.jiaxin.tree.RedBlackTree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String, String> tree = new RedBlackTree<>();
        tree.put("1", "zhangsan");
        tree.put("2", "lisi");
        tree.put("3", "wangwu");
        String r1 = tree.get("1");
        System.out.println(r1);
        String r2 = tree.get("2");
        System.out.println(r2);
        String r3 = tree.get("3");
        System.out.println(r3);

    }
}
