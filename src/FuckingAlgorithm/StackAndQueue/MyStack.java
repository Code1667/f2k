package FuckingAlgorithm.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wq
 * @date 2020-03-25 21:37
 * 用队列实现栈
 * leetcode225
 */
class MyStack {

    /** Initialize your data structure here. */
    public MyStack() {

    }


    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1){
            top = q1.remove();
            q2.add(top);
        }
        top = q1.remove();
        Queue<Integer> temp = q1;   //此时q1为空
        q1 = q2;
        q2 = temp;
        return top;
    }

    /** Get the top element. */
    public int top() {
        while(q1.size()>1){
            top = q1.remove();
            q2.add(top);
        }
        top = q1.remove();
        Queue<Integer> temp = q1;   //此时temp==q1为空
        q1 = q2;
        q2 = temp;
        q1.add(top);
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
