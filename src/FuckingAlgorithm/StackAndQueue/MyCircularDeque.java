package FuckingAlgorithm.StackAndQueue;

/**
 * leetcode641 设计循环双端队列
 */
public class MyCircularDeque {
    //数组
    private int[] queue;
    //头指针
    private int front;
    //尾指针
    private int rear;
    //数组大小
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k + 1; //rear指针最终指向的位置不存放东西
        this.queue = new int[capacity];
        this.front = 0; //指向存放头部元素的位置
        this.rear = 0; //队尾元素的下一个位置（即要插入的位置，始终为空元素）
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        this.front = (this.front - 1 + this.capacity) % this.capacity;
        this.queue[this.front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        this.queue[this.rear] = value;
        this.rear = (this.rear + 1 + this.capacity) % this.capacity;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Ret… an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Ret… an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        this.rear = (this.rear - 1 + this.capacity) % this.capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[this.front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[(this.rear - 1 + this.capacity) % this.capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (this.rear + 1) % capacity == this.front;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
    }
}