package FuckingAlgorithm.StackAndQueue;

import java.util.Stack;


/**
 * @author wq
 * @date 2020-03-26 11:00
 *
 * leetcode224
 */
public class Calculate {

    public static int calculate(String s) {
        if (s.isEmpty() || s.length() == 0) {
            return -1;
        }

        Stack<Integer> stack_data = new Stack<>();  //数字栈
        Stack<Character> stack_op = new Stack<>();   //操作符号栈

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') { //空格跳过
                continue;
            }

            //如果是符号 入符号栈
            if (c == '+' || c == '-' || c == '(') {
                stack_op.push(c);
            } else if (c == ')') { //如果是')'开始计算
                //如果是')'说明 （）内部已经计算完毕 所以操作符号栈顶一定是'('
                stack_op.pop();  //弹出')'
                while (stack_op.size()>0&& isOperator(stack_op.peek())){
                    int b = stack_data.pop();
                    int a = stack_data.pop();
                    int result = cal(a, b, stack_op.pop());
                    stack_data.push(result);
                }
            } else {  //如果是还是数字  计算这个数字 如 1->2->3 = 123
                int total = 0;

                int j=i;  //因为数字可能有好多从i开始  遍历完要用到这个 继续回去遍历i
                for (; j <s.length() ; j++) {
                    char temp = s.charAt(j);
                    if(isDigital(temp)){
                        total = total*10 + temp - '0';
                    }else{
                        break;
                    }
                }
                //长数字拿到 先别急入栈 看看是否能计算
                if(stack_op.isEmpty()||!isOperator(stack_op.peek())){
                    stack_data.push(total);
                }
                while(!stack_op.isEmpty() && isOperator(stack_op.peek())){
                    Character op =stack_op.pop();
                    Integer d = stack_data.pop();
                    stack_data.push(cal(d, total, op));
                }
                // 例如123 + 5  这时j已经是+号后一位了 数字123拿到
                //  i就应从符号位开始遍历，所以
                i = j-1;
            }
        }
        return stack_data.peek();
    }

    public static boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-';
    }

    public static int cal(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        } else {
            return a - b;
        }
    }


    public static void main(String[] args) {

        String s = "(1+(4+5+2)-3)+(6+8)";
        int calculate = calculate(s);
        System.out.println(calculate);


    }

    private static String getType(Object b) {
        return b.getClass().toString();
    }
}
