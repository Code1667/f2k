package FuckingAlgorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 572. 另一个树的子树
 */
public class isSubtree {
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


        TreeNode t11 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t44 = new TreeNode(4);
        t44.left = t11;
        t44.right = t22;

        boolean subtree = isSubtree(t3, t4);
        System.out.println(subtree);

    }


    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null || t==null){
            return false;
        }
        return isSameTree(s,t)
                ||isSubtree(s.left, t)
                ||isSubtree(s.right, t);
    }

    private static boolean isSameTree(TreeNode s, TreeNode t) {
        if(s==null && t==null){
            return true;
        }else if(s==null || t==null){
            return false;
        }
        return s.val==t.val
                && isSameTree(s.left, t.left)
                && isSameTree(s.right, t.right);
    }
}
