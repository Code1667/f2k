package Sort;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-05-13 22:22
 * 希尔排序（基于插入排序）：时间复杂度O(nlogn)
 * 为什么出现？ 因为插入排序只比较相邻
 * 思想：设定一定间隔gap，用间隔组成子数组 对每个子数组进行插入排序，将gap缩小，再进行插入排序...直到gap=0
 */
public class Shell {
    public static void sort(int[] a) {
        //确定gap的最大值
        int h = 1;
        while (h < a.length / 2) {
            h = h * 2 + 1;
        }

        while (h >= 1) {
            //找到待插入元素
            for (int i = h; i < a.length; i++) {
                //把待插入元素插入到有序子序列中
                for (int j = i; j >= h; j = j - h) {
                    //待插入元素是a[j]，比较a[j]和a[j-h]
                    if (a[j] < a[j - h]) {
                        exchange(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
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
        //int[] nums = {7, 1, 8, 6, 2, 3, 5, 4, 2, 0, 6, 10, 5};
        int[] nums = {9,1,2,5,7,4,8,6,3,5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
