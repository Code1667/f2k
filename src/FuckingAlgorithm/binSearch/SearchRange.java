package FuckingAlgorithm.binSearch;

/**
 * @author wq
 * @date 2020-04-16 21:44
 * leetcode 34 在排序数组中查找元素的第一个和最后一个位置
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = left_bound(nums, target);
        range[1] = right_bound(nums, target);
        return range;
    }

    public int left_bound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                end = mid - 1;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int right_bound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                if (mid == nums.length-1 || nums[mid + 1] > target) {
                    return mid;
                }
                begin = mid + 1;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
