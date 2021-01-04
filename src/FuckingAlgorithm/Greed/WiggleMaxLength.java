package FuckingAlgorithm.Greed;

/**
 * @author wq
 * @date 2020-03-28 0:57
 * 摇摆序列 leetcode 376.
 */
public class WiggleMaxLength {
    //状态
    static final int  BEGIN = 0;
    static final int  UP = 1;
    static final int  DOWN = 2;

    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<2){
            return  nums.length;
        }
        int state = BEGIN;
        int max_length = 1;

        for (int i = 1; i < nums.length; i++) { //直接从数组第二位开始比较
            if(nums[i]>nums[i-1]){
                if(state == UP){
                    continue;
                }
                state = UP;
                max_length++;
            }else if(nums[i]<nums[i-1]){
                if(state == DOWN){
                    continue;
                }
                state = DOWN;
                max_length++;
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
    }
}
