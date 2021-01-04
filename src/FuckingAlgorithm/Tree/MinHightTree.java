package FuckingAlgorithm.Tree;


/**
 * Leetcode面试题04.02
 * 最小高度树
 */
public class MinHightTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums,0,nums.length-1);
    }

    //插入nums数组 从left到right
    private static TreeNode insert(int[] nums, int left, int right){
        if(left>right){
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = insert(nums, left, mid-1);
        node.right = insert(nums, mid+1, right);
        return node;
    }
}
