package FuckingAlgorithm.Backtracking;

import java.util.*;

/**
 * @author wq
 * @date 2020-03-30 8:59
 * leetcode
 * 78:子集Ⅰ
 */
public class Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets2(nums);
        print(lists);
    }


    /**
     * 回溯递归法
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generate(0,nums,new ArrayList<>(),res);
        return res;
    }

    //nums = [1,2,3]
    private static void generate(int begin, int[] nums, ArrayList<Integer> item, List<List<Integer>> res) {
        if(begin>=nums.length){
            res.add(new ArrayList<>(item));
            return;
        }
        //从begin索引开始遍历数组。
        //1.包含nums[i]
        item.add(nums[begin]);
        generate(begin+1, nums, item, res);
        //2.不包含nums[i]
        item.remove(item.size()-1);
        generate(begin+1, nums, item, res);

    }

    /**
     * 位运算
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = 1<<nums.length;   //nums = [1,2,3]  3位 对应的二进制最大值为8(111)
        //由于二进制的0/1代表有/无，所以从0-len 就代表所有情况
        for (int i = 0; i < len; i++) {
            List<Integer> tmp = new ArrayList<>();
            StringBuilder str = new StringBuilder(Integer.toBinaryString(i));
            while (str.length() != nums.length) {   //前面不够补0
                str.insert(0, "0");
            }
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    tmp.add(nums[j]);
                }
            }
            result.add(tmp);
        }
        return result;
    }


    /**
     * 打印方法
     * @param lists
     */
    public static void print(List<List<Integer>> lists){
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j)+" ");
            }
            System.out.println();
        }
    }

}
