package FuckingAlgorithm.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 3 无重复最长字串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String  s = "abba";
        String s1 = "abcabcbb";
        String s2 = "bbbb";
        String s3 = "";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                //abba这个例子当到第二个b时候 begin已经到3了，
                //判断第二个a的时候，需要比较上一个a的索引和当前起始索引哪个大，最后赋值给begin
                begin = Math.max(begin, map.get(ch)+1);
            }
            map.put(ch, i);
            maxLength = Math.max(maxLength, i-begin+1);
        }
        return maxLength;
    }

}
