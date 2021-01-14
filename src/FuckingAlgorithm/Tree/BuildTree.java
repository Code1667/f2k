package FuckingAlgorithm.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 2, 1, 7};
        int[] inorder = {9, 3, 2, 1, 7};
        BuildTree test = new BuildTree();
        TreeNode treeNode = test.buildTree(preorder, inorder);
        System.out.println(treeNode);

    }

    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //将中序的(值，索引)存入hash表 以便根据值查找在中序的索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //recur(根节点为先序的第一个元素,左边界,右边界)
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root  根节点在先序中的索引
     * @param left  中序的左边界
     * @param right 中序的右边界
     * @return
     */
    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        //在先序中找到根节点值 创建根节点
        TreeNode node = new TreeNode(preorder[root]);
        //从中序hash表中找到根节点值在中序的索引
        Integer i = map.get(preorder[root]);
        //recur(左子树根节点在先序的索引，左子树在中序的左边界，左子树在中序的右边界)
        node.left = recur(root + 1, left, i - 1);
        //recur(右子树根节点在先序的索引，右子树在中序的左边界，右子树在中序的右边界)
        node.right = recur(root + i - left + 1, i + 1, right);//root+i-left+1 为根索引+左子树长度+1
        //返回根节点
        return node;
    }

}
