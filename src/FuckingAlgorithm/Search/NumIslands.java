package FuckingAlgorithm.Search;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wq
 * @date 2020-05-01 10:05
 * leetcode 200 岛屿数量
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int count_island = 0;
        if(grid.length == 0){
            return count_island;
        }
        int[][] mark = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(mark[i][j] == 0 && grid[i][j] == '1'){
                    BFS(mark, grid, i, j);
                    count_island++;
                }
            }
        }
        return count_island;
    }

    /**
     * 深搜
     * @param mark
     * @param grid
     * @param x
     * @param y
     */
    public void DFS(int[][] mark, char[][] grid, int x, int y){

        mark[x][y] = 1;

        int[] dx = {-1,1,0,0};  //方向数组
        int[] dy = {0,0,-1,1};
        for (int i = 0; i < 4; i++) {

            int newx = x + dx[i];
            int newy = y + dy[i];

            if(newx < 0 || newx >= mark.length ||
            newy < 0 || newy >= mark[newx].length){
                continue;
            }
            if(mark[newx][newy] == 0 && grid[newx][newy] == '1'){
                DFS(mark,grid,newx, newy);
            }
        }
    }

    /**
     * 广搜
     * @param mark
     * @param grid
     * @param x
     * @param y
     */
    public void BFS(int[][] mark, char[][] grid, int x, int y){

        final int[] dx = {-1,1,0,0};  //方向数组
        final int[] dy = {0,0,-1,1};

        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        Pair<Integer,Integer> pair = new Pair<Integer, Integer>(x, y);
        queue.add(pair);//将(x,y)推进队列
        mark[x][y] = 1;

        while (!queue.isEmpty()){
            Pair<Integer, Integer> poll = queue.poll();
            x = poll.getKey();
            y = poll.getValue();

            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if(newx < 0 || newx >= mark.length ||
                        newy < 0 || newy >= mark[newx].length){
                    continue;
                }
                if(mark[newx][newy] == 0 && grid[newx][newy] == '1'){
                    queue.add(new Pair<>(newx, newy));
                    mark[newx][newy] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] aa = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        NumIslands test = new NumIslands();
        int coutn = test.numIslands(aa);
        System.out.println(coutn);
    }
}
