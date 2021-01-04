package FuckingAlgorithm.DynamicPlanning;

/**
 * @author wq
 * @date 2020-05-12 9:27
 * leetcode 53 最大子序和
 *
 * 解题思路：
 * 如何找到dp[i]和dp[i-1]的关系？
 * 将问题转换为求出以第i个数字结尾的子段和 那么必须包含nums[i]。
 * 当包含了nums[i](第i个数字)如何使得子段最大？
 * 结论就是 考虑求第i-1个数字时候的最优解是大于0还是小于0
 * 如果>0   dp[i]=nums[i] + dp[i-1]
 *     <0   dp[i]=nums[i]
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp =  new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]>=0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray test = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        test.maxSubArray(nums);
    }
}
