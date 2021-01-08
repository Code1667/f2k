package FuckingAlgorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 897 递增顺序查找树
 */
public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t8 = new TreeNode(8);
        TreeNode t1 = new TreeNode(1);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);

        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t6.right = t8;
        t2.left = t1;
        t8.left = t7;
        t8.right = t9;

        TreeNode root = increasingBST(t5);
        System.out.println(root);

    }

    static List<Integer> list = new ArrayList<>();
    public static TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode res = new TreeNode();
        TreeNode temp = res;
        for (Integer val : list) {
            temp.right = new TreeNode(val);
            temp = temp.right;
        }
        return res.right;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
