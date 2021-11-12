package com.company;


import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LeetCode230 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1  );
//        root.right = new TreeNode(4);
//        root.left.left = null;
//        root.left.right = new TreeNode(2);

        TreeNode root = new TreeNode(5,new TreeNode(3,new TreeNode(2,new TreeNode(1),null),new TreeNode(4)),new TreeNode(6));


        int k = 4;
        int ans = KthSmakkest(root, k);
        System.out.println(ans);
    }

    public static int KthSmakkest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
