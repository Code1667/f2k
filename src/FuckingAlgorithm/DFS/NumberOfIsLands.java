package FuckingAlgorithm.DFS;

/**
 * leetcode200 岛屿数量
 */
public class NumberOfIsLands {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int r, int c) {

        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        //将遍历过的改为0
        grid[r][c] = '0';
        //上
        dfs(grid, r - 1, c);
        //下
        dfs(grid, r + 1, c);
        //左
        dfs(grid, r, c - 1);
        //右
        dfs(grid, r, c + 1);
    }
}
