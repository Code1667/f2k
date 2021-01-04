package FuckingAlgorithm.DynamicPlanning;

/**
 * leetcode 5 最长回文子串
 */
public class
LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        String subStr = longestPalindrome(s);
        System.out.println(subStr);
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {//首尾不相等，那么以i开头以j结尾的串一定不是回文串
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {//j-1 - (i+1) +1 <2 即：去掉首尾后的子串如果长度小于2则一定是回文
                        dp[i][j] = true;
                    } else { //如果子串长度还是大于2，那么需要参考之前的状态答案，二维表格清楚表示
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //只要dp[i][j]==true 成立，就表示子串s[i...j]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLen && isPalindromic(s, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //判断回文数
    private static boolean isPalindromic(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
