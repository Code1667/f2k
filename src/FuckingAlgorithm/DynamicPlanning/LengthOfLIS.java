package FuckingAlgorithm.DynamicPlanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wq
 * @date 2020-05-13 10:11
 * leetcode 300 最长上升子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //dp[i]代表以第i个元素结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;//以nums第一个元素结尾的上升子序列长度为1
        Arrays.fill(dp, 1);//赋初值1：每个以自己为结尾的子序列默认至少包含自己本身
        int max_len = 1;//初始化返回的结果（长度）
        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                //当前nums[i]对应的数与之前作比较 && 以第i个num结尾的最优解和以第j个num结尾的最优解+1比较
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (max_len < dp[i]) {
                max_len = dp[i];
            }
        }
        System.out.println(max_len);
        return max_len;
    }

    /**
     * 1.设置一个栈将nums[0] push进栈
     * 2.从1至n-1遍历nums数组
     * 若nums[i]>栈顶：将nums[i] push进栈
     * 否则：
     * 从栈底遍历至栈顶，若栈中元素大于等于nums[i]
     * 用nums[i]替换该元素并跳出循环
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> stack = new ArrayList<>();
        stack.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > stack.get(stack.size() - 1)) {
                stack.add(nums[i]);
            } else {
//                for (int j = 0; j < stack.size(); j++) {
//                    if(stack.get(j)>=nums[i]){//为什么有等号：当栈中1、3时候（3为栈顶）对1进行查找 应当替换1而不是把3换掉
//                        stack.remove(j);
//                        stack.add(j, nums[i]);
//                        break;
//                    }
//                }
                int[] temps = stack.stream().mapToInt(Integer::valueOf).toArray();
                int index = binary_search(temps, nums[i]);//二分查找
                stack.remove(index);
                stack.add(index, nums[i]);
            }
        }
        System.out.println(stack.size());
        return stack.size();
    }

    public int binary_search(int[] nums, int target) {
        int index = -1;
        int begin = 0;
        int end = nums.length - 1;
        while (index == -1) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                index = mid;
            } else if (target < nums[mid]) {
                if (mid == 0 || target > nums[mid - 1]) {
                    index = mid;
                }
                end = mid - 1;
            } else if (target > nums[mid]) {
                if(mid==nums.length-1||target<nums[mid+1]){
                    index = mid+1;
                }
                begin = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        LengthOfLIS test = new LengthOfLIS();
        int[] nums0 = {8, 9, 5, 4, 3, 2};
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {10,9,2,5,3,4};

        test.lengthOfLIS2(nums2);
    }
}
