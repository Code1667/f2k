package Sort;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-05-13 22:22
 * 选择排序：时间复杂度O(N^2)=>用了N次交换和(N-1)+(N-2)+···+2+1 =N(N-1)/2 ~ N^2/2次比较
 * 思想：遍历数组，每次选择最小的放入遍历位置i
 * 特点：1.运行时间和输入无关 无论输入全相等的数组或者已经排序的数组运行时间都和随机数组相同
 *       2.数据移动最少。（交换次数和数组大小线性关系）
 */
public class Selection {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {//遍历每个位置
            int min = i;//最小元素的索引
            //寻找后方是否有最小元素 如果有交换索引
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //找到了最小元素的索引后交换元素
            exchange(a, i, min);
        }
    }

    /**
     * 交换数组a中索引x和索引y的值
     * @param a
     * @param x
     * @param y
     */
    public static void exchange(int[] a, int x, int y) {
        int temp =  a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,8,6,2,3,5,4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
