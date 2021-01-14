package FuckingAlgorithm.Tree;


/**
 * Leetcode 104
 * 剑指Offer55
 * 二叉树的深度
 */
public class MaxDeepTree {

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);

        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;

        int balanced = maxDepth(t3);
        System.out.println(balanced);


    }

    //求树的最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}
