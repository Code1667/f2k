package Sort;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-05-13 22:22
 * 冒泡排序（基于插入排序）：时间复杂度O(n^2)
 * 思想：每个元素与后面元素进行比较，大的往后移
 */
public class Bubble {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {//排序的次数（数组元素个数）
            boolean flag = true;
            for (int j = 0; j < a.length - i - 1; j++) {// a.length - i - 1其中-1是为了元素和后面对比时候不越界，-i是减去i个已经排序过
                if (a[j] > a[j + 1]) {
                    exchange(a, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 交换数组a中索引x和索引y的值
     *
     * @param a
     * @param x
     * @param y
     */
    public static void exchange(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 8, 6, 2, 3, 5, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
