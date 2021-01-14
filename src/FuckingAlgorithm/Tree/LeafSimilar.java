package FuckingAlgorithm.Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 叶子相同的树 872
 */
public class LeafSimilar {
    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t9 = new TreeNode(9);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);

        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t5.right = t2;
        t1.left = t9;
        t1.right = t8;
        t2.left = t7;
        t2.right = t4;



        TreeNode t23 = new TreeNode(3);
        TreeNode t25 = new TreeNode(5);
        TreeNode t21 = new TreeNode(1);
        TreeNode t26 = new TreeNode(6);
        TreeNode t27 = new TreeNode(7);
        TreeNode t24 = new TreeNode(4);
        TreeNode t22 = new TreeNode(2);
        TreeNode t29 = new TreeNode(9);
        TreeNode t28 = new TreeNode(8);

        t23.left = t25;
        t23.right = t21;
        t25.left = t26;
        t25.right = t27;
        t21.left = t24;
        t21.right = t22;
        t22.left = t29;
        t22.right = t28;

        boolean fff = leafSimilar(t3, t23);
        System.out.println(fff);


    }


    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }

        dfs(root.left, list);
        if(root.left==null && root.right==null){
            list.add(root.val);
        }
        dfs(root.right, list);
    }
}
