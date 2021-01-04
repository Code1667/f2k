package FuckingAlgorithm.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-03-31 2:22
 * 括号生成 leetcode22
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0,0,n,result,"");
        return result;
    }

    private void dfs(int left, int right, int n, List<String> result, String s) {
        if(right == n){
            result.add(new String(s));
            return;
        }else{
            if(left<n){
                dfs(left+1, right, n, result, s+"(");
            }
             if(right<left){
                dfs(left, right+1, n, result, s+")");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }


}
