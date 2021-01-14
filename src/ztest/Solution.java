package ztest;


public class Solution {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t33 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t44 = new TreeNode(4);

        t1.left = t2;
        t1.right = t22;
        t2.left = t3;
        t2.right = t33;
        t3.left = t4;
        t3.right = t44;


        boolean balanced = isBalanced(t1);
        System.out.println(balanced);


    }

    public static boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private static int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }

        if(Math.abs(left-right) <=1){
            return Math.max(left, right) + 1;
        }else {
            return -1;
        }
    }


}





