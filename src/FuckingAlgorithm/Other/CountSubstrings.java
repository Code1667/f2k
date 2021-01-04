package FuckingAlgorithm.Other;

/**
 * @author wq
 * @date 2020-04-01 21:39
 * leet 647 子串回文数
 */
public class CountSubstrings {

    public static int countSubstrings(String s) {
        int count = 0;  //回文子串数
        for (int i = s.length(); i > 0; i--) {  //外层代表 子串长度
            //j是起始字符可能的位置下标 假如s总长度为5 考虑3个子串的情况 i=3 那么起始位置j有5-i+1=3种可能
            for (int j = 0; j < s.length() - i + 1; j++) {
                String substring = s.substring(j, i + j);//注意substring 的endIdex是开区间
                if (isHW(substring)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isHW(String substring) {
        int len = substring.length();
        char[] chars = substring.toCharArray();
        for (int i = 0; i < chars.length; i++) {    //遍历字符数组首尾相等否
            if (chars[i] != chars[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));

    }
}
