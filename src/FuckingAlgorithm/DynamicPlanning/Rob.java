package FuckingAlgorithm.DynamicPlanning;

/**
 * @author wq
 * @date 2020-05-11 23:21
 * leetcode 198 打家劫舍
 */
public class Rob {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }

        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];//第一个房间的最优解就是本身
        dp[2] = Math.max(nums[0], nums[1]);//前两个房间的最优解是其中最大值
        for (int i = 3; i <= nums.length; i++) {
            //不选第i个房间(最优解也就是前i-1个房间)
            // 选第i个房间(最优解是前前个房间+当前)
            //选与不选的最大值 就是第i个房间的最优解
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        System.out.println(dp[nums.length]);
        return dp[nums.length];
    }

    public static void main(String[] args) {
        Rob r = new Rob();
        int[] nums = {2,7,9,3,1};
        r.rob(nums);
    }
}
