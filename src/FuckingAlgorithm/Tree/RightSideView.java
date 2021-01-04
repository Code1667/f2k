package FuckingAlgorithm.Tree;

import java.util.*;

/**
 * @author wq
 * @date 2020-04-07 1:27
 *
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int len = queue.size(); //len就是第几层

            TreeNode node = null;
            for (int i = 0; i < len; i++) {
                node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(node.val);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);


        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.right = t4;

        RightSideView test = new RightSideView();
        List<Integer> list = test.rightSideView(t1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
