package FuckingAlgorithm.HashAndString;

/**
 * @author wq
 * @date 2020-04-24 22:26
 * leetcode 3 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int max_length = 0; //最大长度
        int[] char_map = new int[128];  //字符哈希
        String word = "";   //当前子串

        int begin = 0; //滑动窗口头指针
        for (int i = 0; i < s.length(); i++) {
            char_map[s.charAt(i)]++;
            if(char_map[s.charAt(i)]==1){   //word中该字符只出现一次
                word += s.charAt(i);
                if(max_length < word.length()){
                    max_length = word.length();
                }
            }else {
                while(begin<i && char_map[s.charAt(i)] > 1){
                    char_map[s.charAt(begin)]--;
                    begin++;
                }
                word = "";
                for (int j = begin; j <= i; j++) {
                    word += s.charAt(j);
                }
            }
        }
        System.out.println(max_length);
        return max_length;
    }

    public static void main(String[] args) {
        String s = "pwwwkew";
        lengthOfLongestSubstring(s);
    }
}
