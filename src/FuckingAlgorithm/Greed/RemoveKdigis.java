package FuckingAlgorithm.Greed;

import java.util.Stack;

/**
 * @author wq
 * @date 2020-03-28 1:32
 * 移除K个数字使得最后数字最小 leetcode 402.
 */
public class RemoveKdigis {
    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - '0';

            while (!(stack.size() == 0) && k > 0 && number < stack.peek()) { //栈不为空 待删除数量>0并且当前数小于栈顶数
                stack.pop();
                k--;
            }
            if (number != 0 || stack.size() != 0) {
                stack.push(number);
            }
        }

        while (k > 0 && stack.size() != 0) { //扫描了一次后，k仍>0怎么办 如num=12345 k=3
            stack.pop();
            k--;
        }

        int size = stack.size();
        for (int j = 0; j < size; j++) {
            sb.append(stack.pop());
        }
        String result = sb.reverse().toString();
        System.out.println("*******" + result + "###########");
        if(result.length()==0){
            return "0";
        }

        return result;
    }

    public static void main(String[] args) {
        //num = "1432219", k = 3
        String num = "10";
        int k=2;
        removeKdigits(num, k);
        System.out.println(removeKdigits(num, k));
    }
}
