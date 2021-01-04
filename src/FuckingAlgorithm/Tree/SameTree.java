package FuckingAlgorithm.Tree;


import FuckingAlgorithm.Tree.TreeNode;

/**
 * leetcode100 相同的树
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(3);
        t11.left = t12;
        t11.right = t13;


        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t23 = new TreeNode(3);

        t21.left = t22;
        t21.right = t23;

        boolean sameTree = isSameTree(t11, t21);
        System.out.println(sameTree);


    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}

