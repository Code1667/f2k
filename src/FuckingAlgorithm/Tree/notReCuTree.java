package FuckingAlgorithm.Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归遍历二叉树
 *
 */
public class notReCuTree {

    /// 用非递归的方法进行先序遍历
    public List<Integer> notReCuPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    // 用非递归的方法进行中序遍历
    public List<Integer> notReCuMidOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    // 用非递归的方法进行后序遍历
    public static List<Integer> notReCuPostOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root!=null || !stack.isEmpty()){
            //后序遍历 左右根，所以先把左子节点都push进栈
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();//第一次从最深的左子节点开始

            //如果当前节点没有右子节点（后序遍历左右根，没有右直接添加根），或者当前节点的右子节点已经被遍历过了
            if(root.right==null || root.right==pre){
                res.add(root.val);//直接添加当前节点
                pre= root;//记录当前节点
                root = null;//当前节点置空
            }else {//如果当前节点有右节点，需要再把当前节点push进栈（换句话说就是还没轮到遍历这个节点呢！）
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
