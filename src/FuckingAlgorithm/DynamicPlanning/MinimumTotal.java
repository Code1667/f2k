package FuckingAlgorithm.DynamicPlanning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-05-12 22:46
 * leetcode 120 三角形最小路径和
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][];
        //初始化dp
        for (int i = 0; i < triangle.size(); i++) {
            dp[i]=new int[triangle.get(i).size()];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = 0;
            }
        }

        //三角形的最后一行是什么？
        for (int i = 0; i < dp.length; i++) {
            dp[dp.length - 1][i] = triangle.get(dp.length - 1).get(i);
        }

        //从倒数第二行往上推
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        MinimumTotal test =  new MinimumTotal();

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> a = new ArrayList<>();
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        test.minimumTotal(list);
    }
}
