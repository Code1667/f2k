package FuckingAlgorithm.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode 46 全排列
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len==0){
            return res;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        dfs(nums,len,0,used,stack,res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> stack, List<List<Integer>> res) {
        if (depth==len){
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(used[i]){
                continue;
            }
            stack.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, used, stack, res);

            //回溯
            stack.removeLast();
            used[i] = false;
        }
    }
}
