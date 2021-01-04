package FuckingAlgorithm.Greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-03-28 22:28
 * 最远跳  leetcode55\45
 *
 */
public class CanJump {

    /**
     * 最小跳几次
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {

        if(nums.length<2){ //不用跳跃
            return 0;
        }
        List<Integer> index = new ArrayList<>();    //最远可跳至的位置
        for (int i = 0; i < nums.length; i++) {
            index.add(i+nums[i]);   //得到每个位置可跳到的位置
        }
        System.out.println(index);
        int current_max_index = nums[0];    //当前可达最远位置
        int pre_max_max_index = nums[0];    //遍历各个位置  各个位置可达最远
        int jump_min = 1;   //最少跳跃次数

        for (int i = 1; i < nums.length; i++) {
            if(i>current_max_index){    //移动到最远可达时候 需在之前进行再次跳跃才能超越最远可达 继续前进
                jump_min++;
                current_max_index = pre_max_max_index;
            }
            if(pre_max_max_index<index.get(i)){
                pre_max_max_index = index.get(i);
            }
        }
        return jump_min;
    }

    public static boolean canJump(int[] nums) {
        List<Integer> index = new ArrayList<>();    //最远可跳至的位置
        for (int i = 0; i < nums.length; i++) {
            index.add(i+nums[i]);   //得到每个位置可跳到的位置
        }

        int max_index = index.get(0);   //初始位置能跳动的最远位置就是nums数组第一俄个数字
        int jump = 0;

        while(jump<index.size() && jump<=max_index){    //如果跳的步数小于可达位置数组并且小于等于最大可达位置可以继续跳
            if(index.get(jump)>max_index){
                max_index = index.get(jump);
            }
            jump++;
        }
        if(jump==nums.length){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));

    }
}
