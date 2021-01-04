package FuckingAlgorithm.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 77 组合
 */
public class Combine {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = combine(n, k);
        System.out.println(combine);

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        // 1,2,3,4 选两个
        boolean[] used = new boolean[n];
        dfs(nums,0, k,used, new ArrayList(), res);
        return res;
    }

    private static void dfs(int[] nums, int begin, int count, boolean[] used, ArrayList<Integer> tempList, List<List<Integer>> res) {
        if(count==0){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if(used[i]){
                continue;
            }

            tempList.add(nums[i]);
            used[i] = true;
            count--;
            dfs(nums, i+1, count, used, tempList,res);

            tempList.remove(tempList.size()-1);
            used[i] = false;
            count++;
        }

    }
}
