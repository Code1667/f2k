package FuckingAlgorithm.StackAndQueue;

/**
 * leetcode 622
 *
 * 实现循环队列
 * <p>
 * 关键：
 *      队尾坐标：tailIndex = (headIndex + count - 1) mod capacity
 *      新增元素位置在队尾的下一个  新增坐标 = (headIndex + count) mod capacity
 */
public class MyCircularQueue {

    //数组
    private int[] queue;
    //头指针
    private int headIndex;
    //队列长度
    private int count;
    //数组大小
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
        this.capacity = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.count == this.capacity) {
            return false;
        }

        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count += 1;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.count == 0) {
            return false;
        }
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count -= 1;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if(this.count==0){
            return -1;
        }
        return this.queue[this.headIndex];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(this.count==0){
            return -1;
        }
        return this.queue[(this.headIndex + this.count - 1) % this.capacity];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return this.count == this.capacity;
    }


    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        boolean param_2 = obj.enQueue(2);
        boolean param_3 = obj.enQueue(3);
        boolean deQueue = obj.deQueue();
        int front = obj.Front();
        int rear = obj.Rear();
        boolean isEmpty = obj.isEmpty();
        boolean isFull = obj.isFull();
    }
}