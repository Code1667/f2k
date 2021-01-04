package FuckingAlgorithm.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wq
 * @date 2020-03-31 0:20
 * leetcode 40 求子集和
 */
public class SubsetSum {

    public static void main(String[] args) {
        int[] candidates ={10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);


    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, candidates, new ArrayList<>(), target, 0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, int[] candidates, List<Integer> temp, int target, int nextIndex){
        if (target == 0){
            if (!res.contains(temp)) {
                res.add(temp);
            }
            return;
        }
        if (nextIndex >= candidates.length || target < 0 || candidates[nextIndex] > target){
            return;
        }
        for (int i = nextIndex; i < candidates.length; i++) {
            if (candidates[i] > target){
                return;
            }
            List<Integer> list = new ArrayList<>(temp);//为了不在dfs时候改变原有temp
            list.add(candidates[i]);
            dfs(res, candidates, list, target - candidates[i], ++nextIndex);
        }
    }
}
