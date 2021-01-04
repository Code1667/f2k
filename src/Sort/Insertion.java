package Sort;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-05-13 22:22
 * 插入排序：时间复杂度O(N^2)=>最坏N^2/2次比较和N^2/2次交换    最好N-1次比较和0次交换
 * 思想：当前索引左边都是有序的，将当前元素插入已经排序元素中的适当位置
 * 特点：1.对一个数组中元素接近有序会比随机数组排序快得多
 */
public class Insertion {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            //将a[i]插入到前面适当位置
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j-1]) {
                    exchange(a, j, j-1);
                }
            }
        }
    }


    /**
     * 交换数组a中索引x和索引y的值
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
