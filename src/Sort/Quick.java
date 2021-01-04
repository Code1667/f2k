package Sort;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-05-13 22:22
 * 快速排序（基于插入排序）：时间复杂度O(nlogn)
 * 思想：找一个基准，再基准左侧找到大于基准的元素，右侧找到小于基准的元素，交换此时找到的两个元素。
 * 继续进行寻找，直到两个指针相撞，交换指针位置与基准位置的元素，此时一次排序完成，再分别对基准两侧进行快排
 *
 * 快速排序和归并的区别：
 * - 快速排序是找到基准，将基准放到正确的排序位置，再将两侧的数组分别排序，因为基准左都 < 基准
 * 基准右侧都 > 基准，只需要两边字数组有序，整个数组自然而然有序了
 * - 归并是将数组分别排序，再进行归并
 */
public class Quick {

    public static void sort(int[] a) {
        int low = 0;
        int high = a.length - 1;
        sort(a, low, high);
    }

    public static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int partition = partition(a, low, high);//返回的是交换后基准的索引

        //递归调用 快排base左侧
        sort(a, low, partition - 1);
        //递归调用 快排base右侧
        sort(a, partition + 1, high);

    }


    private static int partition(int[] a, int low, int high) {
        //确定基准 一般为low对应的元素
        int base = a[low];

        //设置两个指针分别指向最左和最右
        int left = low;
        int right = high;

        while (true) {
            //右边先动，指针往左寻找比base小的元素(比base大或相等的跳过)
            while (a[right] >= base) {
                right--;
                if (right == low) {
                    break;
                }
            }
            //左边，指针往右寻找比base大的元素(比base小或相等的跳过)
            while (a[left] <= base) {
                left++;
                if (left == high) {
                    break;
                }
            }

            /**
             *
             * 到这里有两种情况:
             * 1.i<j 这时a[i]>base a[j]<base ==》交换二者位置即可
             * 2.i=j 即 i挪动到了j所指向的元素时还没找到比base大的  ==》将base与a[i]交换
             */

            //情况1.
            if(left>=right){
                break;
            }else {
                exchange(a, left, right);
            }
        }

        //(情况2.)此时i和j指针指向相同元素，基准与其交换位置
        exchange(a, low, right);

        return right;
    }


    //
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
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
        int[] nums = {7, 1, 8, 6, 2, 3, 5, 4,10,8,5,1,9,7,7};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
