package FuckingAlgorithm.Greed;

import java.util.Arrays;

/**
 * @author wq
 * @date 2020-03-27 23:29
 * 贪心入门  发饼干 leetcode455
 */
public class FindContentChildren {

    public static int findContentChildren(int[] g, int[] s) {
        int children = 0;    //饥饿值数组下标
        int cookie = 0;    //饼干数组下标
        Arrays.sort(g);
        Arrays.sort(s);

        while(g.length!=0 && s.length !=0){
            if(cookie==s.length || children == g.length){
                break;
            }
            if(s[cookie] >= g[children]){
                cookie++;
                children++;
            }else{
                cookie++;
            }
        }
        return children;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};

        findContentChildren(g, s);

    }
}
