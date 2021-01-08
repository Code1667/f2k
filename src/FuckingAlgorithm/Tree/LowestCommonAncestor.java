package FuckingAlgorithm.Tree;

/**
 * @author wq
 * @date 2020-04-04 2:16
 * 最近公共祖先 leetcode236
 */
public class LowestCommonAncestor {
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

        LowestCommonAncestor test = new LowestCommonAncestor();
        TreeNode treeNode = test.lowestCommonAncestor(t5, t2, t5);
        System.out.println(treeNode.val);
    }

    //----------------后序遍历法--------------
    /*
    为什么用后序？
    因为先找左右子树 再看root

    思想：是将找到p或q的节点携带返回 与另一侧的比较 有四种情况
    1.left!=null && right!=null 也就是左子树找到了 右子树也找到了 那么root就是LCA(lowestCommonAncestor)
    2.left==null && right==null 同时为空，说明左右子树都不含p、q 返回null
    3.left==null，说明在右侧找到了p或q，那么将找到的继续携带返回 return right
    4.同3

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;    //left!=null && right!=null 的情况
    }


    //-----------------计数法-----------------
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }

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


}
