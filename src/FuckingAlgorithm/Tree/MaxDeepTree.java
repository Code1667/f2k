package FuckingAlgorithm.Tree;


/**
 * Leetcode 104
 * 剑指Offer55
 * 二叉树的深度
 */
public class MaxDeepTree {
    //求树的最大深度
    public static int maxDepth(TreeNode root) {
        //如果根节点为null 返回0
        if (root == null) {
            return 0;
        }
        //算上根节点 所以从1开始计数
        int left = dfs(root.left,1);
        int right = dfs(root.right,1);
        return left>right?left:right;
    }

    private static int dfs(TreeNode node, int count) {
        if (node==null){
            return count;
        }
        count++;
        int left = dfs(node.left,count);
        int right = dfs(node.right,count);
        return left>right?left:right;
    }
}
