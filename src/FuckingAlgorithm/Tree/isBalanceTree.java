package FuckingAlgorithm.Tree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 */
public class isBalanceTree {

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

        boolean balanced = isBalanced(t3);
        System.out.println(balanced);


    }

    //-------------后序遍历+剪枝-----------------
    public static boolean isBalanced(TreeNode root) {
        return recu(root)!=-1;
    }

    private static int recu(TreeNode node) {
        if(node==null){
            return 0;
        }

        int left = recu(node.left);
        if(left==-1){
            return -1;
        }
        int right = recu(node.right);
        if(right==-1){
            return -1;
        }


        if(Math.abs(left-right)<=1){
            return Math.max(left, right) + 1;
        }else {
            return -1;
        }
    }


    //-----------一般方法：先序遍历+判断深度-----------
    public static boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced2(root.left)
                && isBalanced2(root.right);
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
