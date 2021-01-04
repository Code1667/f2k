package FuckingAlgorithm.Recursion;

import FuckingAlgorithm.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 783  二叉搜索树节点最小距离
 */
public class MinimumDistanceBetweenBSTNodes {


    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t6 = new TreeNode(6);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);

        t4.left = t2;
        t4.right = t6;

        t2.left = t1;
        t2.right = t3;

        int i = minDiffInBST(t4);
        System.out.println(i);
    }



    public static int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        int res = list.get(list.size()-1);
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res,list.get(i) - list.get(i-1));
        }

        return res;
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }

}
