package FuckingAlgorithm.StackAndQueue;

import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] notation ={"3","17","15","-","*","18","6","/","+"};
        int res = caculate(notation);
        System.out.println(res);


    }


    public static int caculate(String[] notation){
        //操作数栈
        Stack<Integer> stack = new Stack<>();

        for (String str : notation) {
            Integer o1;
            Integer o2;
            switch (str){
                case "+":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    stack.push(o2+o1);
                    break;
                case "-":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    stack.push(o2-o1);
                    break;
                case "*":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    stack.push(o2*o1);
                    break;
                case "/":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    stack.push(o2/o1);
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    break;
            }
        }
        Integer res = stack.pop();
        return res;
    }
}
