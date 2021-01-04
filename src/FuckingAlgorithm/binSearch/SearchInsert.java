package FuckingAlgorithm.binSearch;

/**
 * @author wq
 * @date 2020-04-15 16:50
 * leetcode 35
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i<nums.length){
            if(target<=nums[i]){
                break;
            }else{
                i++;
                continue;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
