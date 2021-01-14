package FuckingAlgorithm.Tree;

/**
 * @author wq
 * @date 2021-01-08 8:53
 */
public class kthLargest {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t1 = new TreeNode(1);
//        t5.left = t3;
//        t5.right = t6;
//        t3.left = t2;
//        t3.right = t4;
//        t2.left = t1;

        t3.left = t1;
        t3.right = t4;
        t1.right =t2;



        int i = new kthLargest().kthLargest(t3, 1);
        System.out.println(i);


    }

    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        dfs(root.right);
        if(k==0){
            return;
        }
        k = k-1;
        if(k==0){
            res = root.val;
        }
        dfs(root.left);
    }
}
