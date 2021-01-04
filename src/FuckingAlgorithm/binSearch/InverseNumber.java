package FuckingAlgorithm.binSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wq
 * @date 2020-04-18 11:31
 * leetcode 315 逆序数
 * 思路：
 * 将给定数组逆置，问题转化为求nums[i]前面有多少个比nums[i]小的数
 * 对逆置数组那么进行排序二叉树的插入操作，问题转化为计算有多少个插入元素比当前元素小
 * 排序二叉树的左子树都是比它小的！！！
 *
 */
public class InverseNumber {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) { //注意Integer[]数组的初始值是null
            res[i] = 0;
        }
        List<Integer> list = new ArrayList<>();
        TreeNode2 root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, new TreeNode2(nums[i]), res, i);
        }
        return Arrays.asList(res);
    }

    public TreeNode2 insert(TreeNode2 root, TreeNode2 insert_node, Integer[] res, int i) {
        if (root == null) {
            root = insert_node;
            return root;
        }
        if (insert_node.val <= root.val) { // 注意小于等于插入到左子树，防止多加1
            root.count++;
            root.left = insert(root.left, insert_node, res, i);
        } else {    //右子树
            res[i] += root.count + 1;//比当前插入值小的就是root的count加上root本身
            root.right = insert(root.right, insert_node, res, i);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        Integer[] res = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = 0;
        }
    }

}

class TreeNode2 {
    int val;
    int count;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int val) {
        this.val = val;
        left = null;
        right = null;
        count = 0;
    }
}

