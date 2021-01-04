package FuckingAlgorithm.Tree;


import java.util.LinkedList;

/**
 * 求叶子结点的数值的和
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);

        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;

        System.out.println(deepestLeavesSum(t3));

    }


    public static int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        return bfs(root);
    }

    public static int bfs(TreeNode node) {
        //存放结点的队列
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        int res= 0;
        while (!queue.isEmpty()){
            //清零
            res = 0;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                res += poll.val;
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }
}
