package FuckingAlgorithm.HashAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wq
 * @date 2020-04-22 22:17
 * leetcode290 词语模式
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");//按空格分割str为字符串数组
        Map<Character, String> map = new HashMap<>();

        //如果pattern字符数量和strs中字符串数量不等 说明映射肯定不对
        if (pattern.length() != strs.length) {
            return false;
        }

        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            /**
             * 同样的字符串 不同的pattern字符情况
             */
            if(map.containsValue(strs[i]) && map.get(c)==null){
                return false;
            }
            if (map.get(c)==null) {
                map.put(c, strs[i]);
            } else if (map.get(c).equals(strs[i])) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        boolean flag = wordPattern(pattern, str);
        System.out.println(flag);
    }


}
