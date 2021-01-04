package FuckingAlgorithm.DynamicPlanning;

/**
 * 回文子串的个数
 * leetcode 647
 */
public class CountSubstrings {

    public static void main(String[] args) {
        String s = "fdsklf";
        int res = countSubstrings(s);
        System.out.println(res);

    }

    /**
     * 中心扩散的思想，两个指针从中央往两边移动
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if(s.length()<=1){
            return s.length();
        }
        //回文子串的数量
        int res = 0;
        char[] chars = s.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            res += count(chars, i, i);//以i为中心向两边扩散
            res += count(chars, i, i+1);//以i和i+1为中心
        }
        return res;
    }

    public static int count(char[] c,int i, int j){
        int curr = 0;
        while (i>=0 && j<=c.length-1){
            if(c[i]!=c[j]){
                break;
            }
            curr++;
            i--;//指针左移
            j++;//指针右移
        }
        return curr;
    }
}
