package com.jiaxin.tree;

import com.jiaxin.linear.Queue;

import java.security.Key;

public class BinaryTree <key extends Comparable<key>, value>{
    private Node root;
    private int N;
    private class Node{
        public key key;
        public value value;
        public Node left;
        public Node right;
        public Node(key key, value value, Node left, Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public int size(){
        return N;
    }

    public void put(key key, value value){
        root = put(root, key, value);
    }

    private Node put(Node x, key key, value value) {
        if(x == null){
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        }else if(cmp < 0){
            x.left = put(x.left, key, value);
        }else{
            x.value = value;
        }
        return x;
    }

    public value get(key key){
        return get(root, key);
    }
    public value get(Node x, key key){
        //x树为null
        if(x == null){
            return null;
        }
        //x树不为null
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        }else if(cmp < 0){
            return get(x.left, key);
        }else{
            return x.value;
        }
    }

    public void delete(key key){
        delete(root, key);
    }
    public Node delete(Node x, key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);

        }else if(cmp < 0){
            x.left = delete(x.left, key);
        }else{
            N--;
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node n = x.right;
            while (n.left != null){
                n = n.left;
            }
            Node t = x.right;
            while (t.left != null){
                if(n.left.left == null){
                    n.left = null;
                }else{
                    n = n.left;
                }
            }
            n.left = x.left;
            n.right = x.right;
            x = n;

        }
        return x;
    }

    public key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left != null){
             return min(x.left);
        }else{
            return x;
        }
    }

    public key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right != null){
            return max(x.right);
        }else{
            return x;
        }
    }

    public Queue<key> preErgodic(){
        Queue<key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node x, Queue<key> keys){
        if(x == null){
            return;
        }
        keys.enqueuq(x.key);
        if(x.left != null){
            preErgodic(x.left, keys);
        }
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    public Queue<key> midErgodic(){
        Queue<key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node x, Queue<key> keys){
        if(x == null){
            return;
        }
        if(x.left != null){
            midErgodic(x.left, keys);
        }
        keys.enqueuq(x.key);
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    public Queue<key> afterErgodic(){
        Queue<key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    private void afterErgodic(Node x, Queue<key> keys) {
        if(x == null){
            return;
        }
        if(x.left != null){
            afterErgodic(x.left, keys);
        }
        if(x.right != null){
            afterErgodic(x.right, keys);
        }
        keys.enqueuq(x.key);
    }

    public Queue<key> layerErgodic(){
        Queue<key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueuq(root);
        while(!nodes.isEmpty()){
            Node n = nodes.dequeue();
            keys.enqueuq(n.key);
            if (n.left != null) {
                nodes.enqueuq(n.left);
            }
            if (n.right != null) {
                nodes.enqueuq(n.right);
            }
        }
        return keys;
    }

    public int maxDepth(){
        return maxDepth(root);
    }
    private int maxDepth(Node x){
        if(x == null){
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        if(x.left != null){
            maxL = maxDepth(x.left);
        }
        if (x.right != null) {
            maxR = maxDepth(x.right);
        }
        max = Math.max(maxL,maxR) + 1;
        return max;
    }

}
