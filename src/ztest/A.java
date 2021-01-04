package ztest;

public class A {

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a==b);
    }

    private int findElement(int[][] nums, int target) {
        int row = 0, column = 0;
        while (row < nums.length) {
            int colMax = nums[row].length - 1;
            if (nums[row][column] <= target && nums[row][colMax] >= target) {
                for (int i = 0; i < nums[row].length; i++) {
                    if (nums[row][i] == target) {
                        return nums[row][i];
                    }
                }
            } else {
                row++;
            }
        }
        return -1;
    }


    public static boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}