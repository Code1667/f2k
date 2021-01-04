package FuckingAlgorithm.StackAndQueue;

import java.util.Stack;

/**
 * 字符编码
 * leetcode 394
 *
 * @author wq
 * @date 2020-11-21 14:44
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "z3[a2[xy]]ef";
        String res = decodeString(s);
        System.out.println(res);


    }


    /**
     * 双栈（字符栈+数字栈）
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int multi = 0;
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_ans = new Stack<>();
        for (Character c:s.toCharArray()){
            if(c=='['){//记录倍数与之前字符串，然后清空
                stack_multi.push(multi);
                stack_ans.push(ans.toString());
                multi = 0;
                ans = new StringBuilder();
            }else if(c==']'){
                StringBuilder tmp = new StringBuilder();
                int curr_multi = stack_multi.pop();
                for (int i = 0; i < curr_multi; i++) {
                    tmp.append(ans);
                }
                ans = new StringBuilder(stack_ans.pop()+tmp);
            }else if(c>='0'&&c<='9'){
                multi = multi*10 + Integer.parseInt(c+"");
            }else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
