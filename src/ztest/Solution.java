package ztest;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        postOrder(root);

    }


    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static void postOrder(TreeNode root){
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                if(root.right==null || root.right==pre){
                    System.out.println(root.val);
                    pre = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }

        }
    }

}





