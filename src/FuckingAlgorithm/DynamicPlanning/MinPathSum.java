package FuckingAlgorithm.DynamicPlanning;

/**
 * @author wq
 * @date 2020-05-13 17:31
 * leetcode 64 最小路径和
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];//走到i，j的最优路径和

        //左上角开始
        dp[0][0] = grid[0][0];
        //第一行
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        System.out.println(dp[grid.length-1][grid[0].length-1]);
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid2 = {{1,2},{1,1}};
        MinPathSum test = new MinPathSum();
        test.minPathSum(grid1);
    }
}
