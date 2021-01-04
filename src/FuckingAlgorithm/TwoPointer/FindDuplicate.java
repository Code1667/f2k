package FuckingAlgorithm.TwoPointer;

/**
 * leetcode287 寻找重复数
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        findDuplicate(nums);

    }


    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int first = 0;
        int sec = slow;
        while (first!=sec){
            first = nums[first];
            sec = nums[sec];
        }
        System.out.println(first);
        return first;
    }


}
