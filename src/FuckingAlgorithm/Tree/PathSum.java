package FuckingAlgorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-04-03 23:48
 * 路径求和 leetcode 113
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode root,int sum,List<Integer> path,List<List<Integer>> result){
        if(root == null){
            return ;
        }
        path.add(root.val);
        int val = sum - root.val;
        if(root.left==null&&root.right==null){
            if(val==0){
                result.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        dfs(root.left, val, path, result); //注意new ArrayList，如果不new 不会回退
        path.remove(path.size()-1);
        dfs(root.right, val, path, result);
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

        System.out.println(new PathSum().pathSum(t5, 22));

    }
}
