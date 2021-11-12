package com.jiaxin.test;

import com.jiaxin.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> bt = new BinaryTree();
        bt.put(1, "张三");
        bt.put(2, "李四");
        bt.put(3, "王五");
        System.out.println("插入完毕后元素的个数：" + bt.size());
        System.out.println("键2对应的元素是：" + bt.get(2));
        bt.delete(3);
        System.out.println("删除后的元素个数是：" + bt.size());
        System.out.println("删除后键3对应的元素是：" + bt.get(3));

    }
}
