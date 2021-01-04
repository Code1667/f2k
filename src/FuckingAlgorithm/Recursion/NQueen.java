package FuckingAlgorithm.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-04-01 2:57
 * leetcode 51 N皇后
 */
public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<List<Integer>> mark = new ArrayList<>();   //标记棋盘，0
        List<String> location = new ArrayList<>();  //存储某个摆放结果，完成一次递归查找 add进result

        for (int i = 0; i < n; i++) {
            mark.add(new ArrayList<>());//创造行空间
            for (int j = 0; j < n; j++) {
                mark.get(i).add(0); //每一行置零
            }
            location.add(new String());
            for (int j = 0; j < n; j++) {
                location.add(".");
            }
        }
        generate(0,n,location,result,mark);

        return result;
    }

    /**
     *  @param k 代表正在放置第k行的皇后
     * @param n
     * @param location
     * @param result
     * @param mark
     */
    private void generate(int k, int n, List<String> location, List<List<String>> result, List<List<Integer>> mark) {
        if(k==n){
            result.add(location);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(mark.get(k).get(i)==0){
                List<List<Integer>> temp = new ArrayList<>();//回溯用的状态存储

            }

        }

    }


    public static void main(String[] args) {

    }
}
