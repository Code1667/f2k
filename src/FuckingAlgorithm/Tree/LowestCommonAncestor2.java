package FuckingAlgorithm.Tree;

/**
 * @author wq
 * @date 2020-04-04 11:16
 * 最近公共祖先 leetcode236
 */
public class LowestCommonAncestor2 {
    private TreeNode ans = null;
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        if (currentNode == null) {
            return false;
        }

        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        if (mid + left + right == 2) {
            this.ans = currentNode;
        }

        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t11 = new TreeNode(11);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2);
        TreeNode t8 = new TreeNode(8);
        TreeNode t13 = new TreeNode(13);
        TreeNode t4_r = new TreeNode(4);
        TreeNode t5_r = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);


        t5.left = t4;
        t5.right = t8;
        t4.left = t11;
        t11.left = t7;
        t11.right = t2;
        t8.left = t13;
        t8.right = t4_r;
        t4_r.left = t5_r;
        t4_r.right = t1;

        LowestCommonAncestor2 solve = new LowestCommonAncestor2();
        solve.lowestCommonAncestor(t5, t2, t5_r);

    }
}
