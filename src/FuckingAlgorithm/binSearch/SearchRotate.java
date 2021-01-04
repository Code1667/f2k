package FuckingAlgorithm.binSearch;

/**
 * @author wq
 * @date 2020-04-16 22:41
 * leetcode 33
 * 如果 target 在[mid+1,high] 序列中，则low = mid+1,否则 high = mid,关键是如何判断 target在[mid+1,high]序列中,具体判断如下：
 * 当[0, mid] 序列是升序: nums[0] <= nums[mid], 当target > nums[mid] || target < nums[0] ,则向后规约
 * 当[0, mid] 序列存在旋转位: nums[0] > nums[mid],当target < nums[0] && target > nums[mid],则向后规约
 * 当然其他其他情况就是向前规约了
 *
 */
public class SearchRotate {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin < end) {
            int mid = (begin + end) / 2;
            //[0,mid]是升序 而target在后面出现旋转的区间
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                begin = mid+1;

                //[0,mid]出现旋转 而target在后面没有旋转的区间
            } else if (target > nums[mid] && target < nums[0]) { //
                begin = mid + 1;
            } else { //其他在[0,mid]中找的情况
                end = mid;
            }
        }
        return begin == end && nums[begin] == target ? begin : -1;
    }

    public static void main(String[] args) {

    }
}
