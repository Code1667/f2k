package FuckingAlgorithm.Backtracking;

import java.util.*;

/**
 * @author wq
 * @date 2020-03-30 8:59
 * leetcode
 * 90:带重复子集Ⅱ
 */
public class Subset2 {
    public static void main(String[] args) {

        int[] nums = {1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        List<List<Integer>> subsets = subsets(nums);

        System.out.println(lists);

        System.out.println(subsets);
    }

    /**
     * 包含重复元素的子集
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //对数组元素进行排序，保证重复元素必相邻，方便后续剪枝
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);   //再开始看非空子集
        return result;
    }

    //回溯函数
    //路径：已作出的选择-track已包含的数组元素
    //选择列表：当前可选择的数组元素（数组nums中start索引及之后的元素）
    //结束条件：正向遍历至数组的末尾时
    public static void backtrack(int start, int[] nums, List<Integer> item, List<List<Integer>> result){
        result.add(new ArrayList<>(item));   //第一次将把空集先添加进去

        for(int j = start; j<nums.length;j++){
            //同层剪枝：同一层的两条不同路径中加入的元素出现重复时（数组已排序） → 跳过当次循环
            if(j>start && nums[j] == nums[j-1]){
                continue;
            }
            //将子集放入
            item.add(nums[j]);
            backtrack(j+1, nums, item, result);
            //不放入
            item.remove(item.size()-1);
        }
    }


    //------------------------------Set集合法----------------------------------


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        cul(0,nums,new ArrayList<>(),res, set);
        return res;
    }

    private static void cul(int i, int[] nums, ArrayList<Integer> item, List<List<Integer>> res,Set<List<Integer>> set) {
        if(i==nums.length){
            if(!set.contains(item)){
                set.add(new ArrayList<>(item));
                res.add(new ArrayList<>(item));
            }
            return;
        }
        //包含当前元素
        item.add(nums[i]);
        cul(i+1, nums, item, res,set);
        //不包含当前元素
        item.remove(item.size()-1);
        cul(i+1, nums, item, res,set);
    }


}
