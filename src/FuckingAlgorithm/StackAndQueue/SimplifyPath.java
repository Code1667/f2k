package FuckingAlgorithm.StackAndQueue;

import java.util.Stack;

/**
 * leetcode 71简化路径
 * @author wq
 * @date 2020-11-20 10:15
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack();

        for (String s : split) {
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!s.equals("")&&!s.equals(".")){
                stack.push(s);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/"+stack.get(i));
        }
        return sb.toString();
    }
}
