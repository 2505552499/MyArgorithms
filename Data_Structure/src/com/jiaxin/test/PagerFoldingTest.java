package com.jiaxin.test;

import com.jiaxin.linear.Queue;

public class PagerFoldingTest {
    public static void main(String[] args) {
        Node<String> tree = createTree(2);
        printTree(tree);
    }

    public static Node<String> createTree(int N){
        Node<String> root = null;
        for(int i = 0; i < N; i++){
            if(i == 0){
                root = new Node<>("down", null, null);
                continue;
            }
            Queue<Node> queue = new Queue<>();
            queue.enqueuq(root);
            while(!queue.isEmpty()){
                Node<String> tmp = queue.dequeue();
                if (tmp.left != null) {
                    queue.enqueuq(tmp.left);
                }
                if (tmp.right != null) {
                    queue.enqueuq(tmp.right);
                }
                if (tmp.left == null && tmp.right == null) {
                    tmp.left = new Node<String>("down", null, null);
                    tmp.right = new Node<String>("up", null, null);
                }
            }

        }
        return root;
    }

    public static void printTree(Node<String> root){
        if(root == null){
            return;
        }
        if(root.left != null){
            printTree(root.left);
        }
        System.out.print(root.item + " ");
        if (root.right != null) {
            printTree(root.right);
        }
    }


    public static class Node<T>{
        public T item;
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
