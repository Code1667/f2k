package FuckingAlgorithm.DynamicPlanning;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-05-12 19:49
 * leetcode 322 零钱兑换
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5,7,10};
        int amount = 12;

        CoinChange test = new CoinChange();
        test.coinChange(coins, amount);

    }
    /**
     *
     * @param coins 钞票面额数组
     * @param amount 金额
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        //初始化
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {//循环面值 看当前i面额 可以由哪些coins[j]组成
                if(i - coins[j]>=0 && dp[i-coins[j]] !=-1){
                    if(dp[i] == -1 || dp[i] > dp[i-coins[j]] + 1){
                        dp[i] = dp[i-coins[j]] + 1;
                    }
                }
            }
        }
        System.out.println(dp[amount]);
        return dp[amount];
    }

}

/**
 * 解题思路：
 * coins=[1,2,5,7,10]
 * account = 14
 * dp[i]代表金额i的最优解(即最小使用张数)
 * 数组dp[]中存储金额1到金额14的最优解
 *
 * 计算dp[i]时 ，dp[0] dp[1] dp[2]...dp[i-1]都是已知的：
 * 而金额i可由:
 * i-1 与 coins[0]组合
 * i-2 与 coins[1]组合
 * i-5 与 coins[2]组合
 * i-7 与 coins[3]组合
 * i-10 与 coins[4]组合
 * 即状态i可由 i-1、i-2、i-5、i-7、i-10，五个状态转移到
 * dp[i] = min(dp[i-1],dp[i-2],dp[i-5],dp[i-7],dp[i-10]) + 1
 */