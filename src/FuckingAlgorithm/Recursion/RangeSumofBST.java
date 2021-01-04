package FuckingAlgorithm.Recursion;

import FuckingAlgorithm.Tree.TreeNode;

/**
 * 938  二叉搜索树的范围和
 */
public class RangeSumofBST {
    public static void main(String[] args) {
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t15 = new TreeNode(15);
        TreeNode t3 = new TreeNode(3);
        TreeNode t7 = new TreeNode(7);
        TreeNode t18 = new TreeNode(18);

        t10.left = t5;
        t10.right = t15;
        t5.left=  t3;
        t5.right = t7;

        t15.right = t18;

        int res = rangeSumBST(t10, 7, 15);
        System.out.println(res);

    }


    static int ans;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        dfs(root,low,high);
        return ans;
    }

    private static void dfs(TreeNode root, int low, int high) {
        if(root==null){
            return;
        }
        else if(root.val<low){
            dfs(root.right,low,high);
        }else if(root.val>high){
            dfs(root.left,low,high);
        }else {
            ans += root.val;
            dfs(root.left,low,high);
            dfs(root.right,low,high);
        }
    }


}
