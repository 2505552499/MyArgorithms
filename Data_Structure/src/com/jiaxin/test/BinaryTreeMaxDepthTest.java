package com.jiaxin.test;

import com.jiaxin.linear.Queue;
import com.jiaxin.tree.BinaryTree;

public class BinaryTreeMaxDepthTest {
    public static void main(String[] args) {
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("C", "3");
        bt.put("H", "8");

        int maxDepth = bt.maxDepth();
        System.out.println(maxDepth);


    }
}
