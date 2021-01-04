package FuckingAlgorithm.HashAndString;

/**
 * @author wq
 * @date 2020-04-22 21:54
 * leetcode 409最长回文串
 * 字符哈希算法
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int max_length = 0; //偶数字符的总和
        int flag = 0; // 中心字符
        int count = 0;  //每个字符出现的次数

        int[] hash = new int[128];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i]%2==0){
                count += hash[i];
            }else{
                flag = 1;
                count += hash[i] - 1;
            }
        }
        System.out.println(count+flag);
        return count + flag;
    }

    public static void main(String[] args) {
        String s = "abacddcca";
        longestPalindrome(s);
    }
}
