package FuckingAlgorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wq
 * @date 2020-04-05 21:47
 * leetcde 114
 *
 * 1.将左子树插入到右子树的地方
 * 2.将原来的右子树接到左子树的最右边节点
 * 3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
 */
public class Flatten {
    public  void flatten(TreeNode root) {
        while(root!=null){
            //如果当前根节点的左子树为空直接下一个节点
            if(root.left == null){
                root = root.right;
            }else{
                //找左子树最右边的节点
                TreeNode rightSon = root.left;
                while (rightSon.right!=null){
                    rightSon = rightSon.right;
                }
                //将原来的右子树挪到左子树最右边的节点后
                rightSon.right = root.right;
                //将左子树边为右子树
                root.right = root.left;

                root.left = null;
                root = root.right;
            }
        }
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

        Flatten test =  new Flatten();
        test.flatten(t5);
        test.BFS(t5);

    }

    public static void BFS(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode poll_node = queue.poll();
            System.out.println(poll_node.val);
            if(poll_node.left!=null){
                queue.offer(poll_node.left);
            }
            if(poll_node.right!=null){
                queue.offer(poll_node.right);
            }
        }

    }
}
