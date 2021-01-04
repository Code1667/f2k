package Sort;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-05-14 11:49
 * 堆排序
 *
 */
public class Heap {
    public static void sort(int[] a) {
        //1.构建大顶堆
        //a.length-1是最后元素索引，(a.length-1-1)/2是其父结点索引
        for (int i = (a.length-1-1)/2; i >=0 ; i--) {
            //调整堆结构
            adjustHeap(a,i,a.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = a.length-1; i >= 0; i--) {
            exchange(a, 0, i);
            adjustHeap(a,0,i);
        }
    }

    /**
     * 调整大顶堆
     * @param a
     * @param i 子树父结点
     * @param length 子树长度
     */
    private static void adjustHeap(int[] a, int i, int length) {
        int temp = a[i];//取出当前元素i
        for (int j = i*2+1; j < length; j=j*2+1) {//从i的左节点开始
            if(j+1<length && a[j]<a[j+1]){//如果左子结点小于右子结点，j指向右子结点
                j++;
            }
            if(a[j]>temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                a[i] = a[j];
                i = j;
            }else{
                break;
            }
            a[i] = temp;//将temp值放到最终的位置
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
