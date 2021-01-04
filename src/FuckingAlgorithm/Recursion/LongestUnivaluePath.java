package FuckingAlgorithm.Recursion;

import FuckingAlgorithm.Tree.TreeNode;

/**
 * leetcode687 最长同值路径
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(4);

//        root.left = t1;
//        root.right = t2;
//
//        t2.right = t3;
//
//        t1.left = t4;
//        t1.right = t5;

        int ans = longestUnivaluePath(root);
        System.out.println(ans);

    }

    static int ans = 0;
    public static int longestUnivaluePath(TreeNode root) {
        find(root);
        return ans;
    }

    /**
     * 搜索以root为起点的最长同值路径,要么经过左子树，要么经过右子树
     */
    public static int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 以root为起点的最长同值路径
        int maxLength = 0;
        // 以root.left为起点的最长同值路径
        int left = find(root.left);
        // 以root.right为起点的最长同值路径
        int right = find(root.right);
        // 情况2，不需要更新maxLength，但要更新结果
        if (root.left != null && root.right != null &&
                root.val == root.left.val && root.val == root.right.val) {
            ans = Math.max(ans, left + right + 2);
        }
        // 从左右子树中选取最长同值路径
        if (root.left != null && root.val == root.left.val) {
            maxLength = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            maxLength = Math.max(maxLength, right + 1);
        }
        // 更新结果
        ans = Math.max(ans, maxLength);
        return maxLength;
    }

}
