package FuckingAlgorithm.Heap;

import java.util.PriorityQueue;

/**
 * leetcode703 数据中第K大元素
 *
 * 优先队列实现
 */
public class KthLargest {

    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargest(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < limit) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5));;   // return 5
        System.out.println(kthLargest.add(10));;  // return 5
        System.out.println(kthLargest.add(9));;   // return 8
        System.out.println(kthLargest.add(4));;   // return 8
        System.out.println(-2>>1);
    }

}