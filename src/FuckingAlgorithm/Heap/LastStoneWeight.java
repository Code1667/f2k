package FuckingAlgorithm.Heap;

import java.util.PriorityQueue;

/**
 * leetcode1046 最后一块石头的重量
 */
public class LastStoneWeight {


    public static int lastStoneWeight(int[] stones) {
        //构建大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> (o2-o1)));
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        //选出最重的石头
        while (queue.size()>1){
            int y = queue.poll();
            int x = queue.poll();
            //新石头
            int n =y - x;
            if(n!=0){
                queue.add(n);
            }
        }
        if(queue.size()==0){
            return 0;
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] stones = {5,9,4,6,2,3};
        int i = lastStoneWeight(stones);
        System.out.println(i);
    }
}
