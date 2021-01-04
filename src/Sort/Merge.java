package Sort;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-05-13 22:22
 * 归并排序：时间复杂度O(nlogn)
 * 思想：将数组分组，分别对分组后的数组排序，然后进行归并
 */
public class Merge {

    private static int[] assist;

    //归并[begin,mid][mid+1,end]
    public static void sort(int[] a) {
        //1.初始化辅助数组assist
        assist = new int[a.length];
        //2.定义low和high变量分别记录最小索引和最大索引
        int low = 0;
        int high = a.length - 1;
        //3.调用sort重载完成从low到high的排序
        sort(a, low, high);
    }

    private static void sort(int[] a, int low, int high) {
        //对low到high进行分组
        int mid = (low + high) / 2;
        //安全性校验 注意mid=low是可以的
        if (high <= low || mid < low) {
            return;
        }
        //分别对a[low,mid]和a[mid+1,high]进行排序
        sort(a, low, mid);
        sort(a, mid + 1, high);
        //再把分组的数据进行归并
        merge(a, low, mid, high);

    }

    /**
     * 对a数组从low到mid ，和mid+1到high分别排序最后进行归并
     *
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int[] a, int low, int mid, int high) {
        //1.对两个数组分别排序

        //2.定义三个指针分别指向左右两个数组的起始位和辅助数组的起始位
        int i = low;
        int p1 = low;
        int p2 = mid + 1;

        //3.比较两个指针的元素，小的元素放入assist并且指针后移，assist的指针往后移
        while (p1 <= mid && p2 <= high) {
            //比较两指针的值
            if (a[p1] < a[p2]) {
                assist[i] = a[p1];
                p1++;
            } else {
                assist[i] = a[p2];
                p2++;
            }
            i++;
        }

        //两种特殊情况，p1走完了，p2还没走完，反之
        while (p1 <= mid) {
            assist[i] = a[p1];
            p1++;
            i++;
        }
        while (p2 <= high) {
            assist[i] = a[p2];
            p2++;
            i++;
        }

        //将辅助数组的元素覆盖原数组的元素
        for (int j = low; j <= high; j++){
            a[j] = assist[j];
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
        int[] nums = {7, 1, 8, 6, 2, 3, 5,4,10,9,5,2,4,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
