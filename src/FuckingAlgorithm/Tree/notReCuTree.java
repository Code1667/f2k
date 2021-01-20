package FuckingAlgorithm.Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归遍历二叉树
 */
public class notReCuTree {

    // 非递归前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            res.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return res;
    }

    // 非递归中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }

    // 用非递归的方法进行后序遍历
    public static List<Integer> notReCuPostOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            //后序遍历 左右根，所以先把左子节点都push进栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();//第一次从最深的左子节点开始

            //如果当前节点没有右子节点（后序遍历左右根，没有右直接添加根），或者当前节点的右子节点已经被添加过了
            if (root.right == null || root.right == pre) {
                res.add(root.val);//直接添加当前节点
                pre = root;//记录当前节点
                root = null;//当前节点置空
            } else {//如果当前节点有右节点，需要再把当前节点push进栈（换句话说就是还没轮到遍历这个节点呢！）
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }
}
