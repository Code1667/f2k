package FuckingAlgorithm.Tree;


import java.util.LinkedList;
import java.util.Queue;
/**
 * leetcode101 对称二叉树
 */
public class SymmetricTree {

    /**
     * dfs
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }

        return left.val== right.val
                && isMirror(left.right,right.left)
                && isMirror(left.left,right.right);
    }



    private boolean isMirrorBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1==null && t2==null){
                continue;
            }
            if(t1==null||t2==null){
                return false;
            }
            if(t1.val!=t2.val){
                return false;
            }

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}

