package FuckingAlgorithm.Tree;

/**
 * 剑指 Offer 26. 树的子结构
 */
public class isSubStructure {
    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);

        t3.left = t4;
        t3.right = t5;
        t4.left = t1;
        t4.right = t2;


        TreeNode t33 = new TreeNode(3);
        TreeNode t11 = new TreeNode(1);
        TreeNode t44 = new TreeNode(4);
        t33.left = t44;

        boolean isSubStructure = isSubStructure(t3, t11);
        System.out.println(isSubStructure);

    }


    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B)
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B);
    }

    private static boolean recur(TreeNode a, TreeNode b) {
        if (b == null) {//b已经遍历到叶节点的下一个节点(null)
            return true;
        }
        if (a == null || a.val != b.val) {//b还没遍历完  a遍历完了 或者值不相等
            return false;
        }
        return recur(a.left, b.left) && recur(a.right, b.right);
    }
}
