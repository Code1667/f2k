package FuckingAlgorithm.Tree;

/**
 * 二叉树搜索树的最近公共祖先 leetcode236
 */
public class LowestCommonAncestor2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t8 = new TreeNode(8);
        TreeNode t0 = new TreeNode(0);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);

        root.left = t2;
        root.right = t8;
        t2.left = t0;
        t2.right = t4;
        t8.left = t7;
        t8.right = t9;
        t4.left = t3;
        t4.right = t5;

        LowestCommonAncestor2 test = new LowestCommonAncestor2();
        TreeNode res = test.lowestCommonAncestor(root, t3, t5);
        System.out.println(res);
    }

    /**
     * 本题利用二叉搜索树的性质
     * 1.如果p、q都在root的左侧，则进入root.left
     * 2.如果p、q都在root的右侧，则进入root.right
     * 3.如果异侧，说明root就是LCA(lowestCommonAncestor)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else break;
        }
        return root;
    }


}
