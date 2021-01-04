package FuckingAlgorithm.DynamicPlanning;

/**
 * @author wq
 * @date 2020-05-11 22:28
 * leetcode 70 爬楼梯
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        //从3阶开始就可以算出具体多少种方法了
        //与最后一个台阶直接相关的就是n-1和n-2中的方法剩下的都包含在其中
        // 所以由1，2推3····一直推出所求n个台阶的方法
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        c.climbStairs(5);
    }

}
