package FuckingAlgorithm.StackAndQueue;

import java.util.Stack;

/**
 * @author wq
 * @date 2020-03-26 9:10
 * 验证栈序列
 * leetcode 946
 *
 */
public class ValidateStackSequences {

    private static Stack<Integer> stack = new Stack<>();

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty()&&stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};

        System.out.println(validateStackSequences(pushed, popped));
    }
}
