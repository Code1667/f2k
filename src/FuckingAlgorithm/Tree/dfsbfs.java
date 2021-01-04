package FuckingAlgorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author wq
 * @date 2020-04-07 0:41
 * 二叉树的深度优先和广度优先搜索
 *
 */
public class dfsbfs {
    List<Integer> res = new ArrayList<>();

    /**
     * 深度优先遍历（递归）
     */
    private void dfs_recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);

        //递归遍历左子树和右子树
        dfs_recursion(root.left);
        dfs_recursion(root.right);
    }

    /**
     * 深度优先遍历（非递归）
     */
    private void dfs(TreeNode root) {
        // 栈用来存储右孩子
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            res.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            curr = curr.left;
            if (curr == null && !stack.isEmpty()) {
                curr = stack.pop();
            }
        }
    }

    /**
     * 广度优先遍历（递归）
     */
    private void bfs_recursion(TreeNode root) {
        // 每一层都要借助一个 List 存储元素
        List<List<Integer>> bfsRes = new ArrayList<>();
        find(bfsRes, 0, root);
        for (int i = 0; i < bfsRes.size(); i++) {
            List<Integer> curr = bfsRes.get(i);
            res.addAll(curr);
        }
    }
    /**
     * 将第 level 层的 node 节点放入 res 的第 level 个集合中
     * @param res
     * @param level
     * @param node
     */
    private void find(List<List<Integer>> res, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (res.size() <= level) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            res.add(list);
        } else {
            List<Integer> list = res.get(level);
            list.add(node.val);
        }

        find(res, level+1, node.left);
        find(res, level+1, node.right);
    }


    /**
     * 广度优先遍历（非递归）
     */
    private void bfs(TreeNode root) {
        // 利用队列先进先出的性质存储节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            res.add(curr.val);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
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


        dfsbfs test = new dfsbfs();
        test.dfs(t5);
    }
}
