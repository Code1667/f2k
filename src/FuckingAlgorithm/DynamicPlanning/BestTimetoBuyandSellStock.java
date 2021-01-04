package FuckingAlgorithm.DynamicPlanning;

import java.util.Arrays;

/**
 * leetcode 122 买股票的时机
 */
public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int[] nums2 = {7, 6, 4, 3, 1};
        int price = dpMaxProfit(nums);
        System.out.println(price);
    }


    /**
     * 暴力解法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxPrice = 0;
        //第i天买入股票可获得的最大利润数组dp
        int[] dp = new int[prices.length + 1];
        Arrays.fill(dp, -1);

        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                if (buy <= prices[j]) {
                    dp[i + 1] = Math.max(dp[i + 1], prices[j] - buy);
                }
            }
            maxPrice = Math.max(maxPrice, dp[i + 1]);
        }
        return maxPrice;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public static int dpMaxProfit(int[] prices){
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
