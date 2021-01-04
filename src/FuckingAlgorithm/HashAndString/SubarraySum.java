package FuckingAlgorithm.HashAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 560 和为K的子数组
 * @author wq
 * @date 2020-11-19 15:33
 */
public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {0,0};
        int k = 0;
        int res = subarraySum2(nums, k);
        System.out.println(res);

    }

    /**
     * 暴力枚举法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0 ; j--) {
                sum += nums[j];
                if(k==sum){
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 前缀和法（优化）
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0,pre=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre-k)){
                count += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return count;
    }
}
