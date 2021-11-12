package com.jiaxin.test;

import com.jiaxin.linear.Queue;
import com.jiaxin.tree.BinaryTree;

public class BinaryTreeErgodicTest {
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
        //前序遍历
        /*Queue<String> keys = bt.preErgodic();
        for (String key : keys) {
            String value = bt.get(key);
            System.out.println(key + ":" + value);
        }*/

        //中序遍历
        /*Queue<String> keys = bt.midErgodic();
        for (String key : keys) {
            String value = bt.get(key);
            System.out.println(key + ':' + value);*/

        /*//后序遍历
        Queue<String> keys = bt.afterErgodic();
        for (String key : keys) {
            String value = bt.get(key);
            System.out.println(key + ":" + value);*/

        //层序遍历
        Queue<String> keys = bt.layerErgodic();
        for (String key : keys) {
            String value = bt.get(key);
            System.out.println(key + ":" + value);
        }


    }
}
