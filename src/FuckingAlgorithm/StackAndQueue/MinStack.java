package FuckingAlgorithm.StackAndQueue;

import java.util.Stack;

/**
 * leetcode155
 */
public class MinStack {

    /** initialize your data structure here. */
    public MinStack() {

    }


    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> s_min = new Stack<>();

    public void push(int x) {
        s.push(x);

        if(s_min.isEmpty()){
            s_min.push(x);
        }else{
            if(x>s_min.peek()){
                x = s_min.peek();
            }
            s_min.push(x);
        }

    }

    public void pop() {
        s.pop();
        s_min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return s_min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */