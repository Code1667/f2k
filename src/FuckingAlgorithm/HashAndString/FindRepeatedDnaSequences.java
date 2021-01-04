package FuckingAlgorithm.HashAndString;

import java.util.*;

/**
 * @author wq
 * @date 2020-04-24 23:16
 * leetcode 187 重复的DNA序列
 */
public class FindRepeatedDnaSequences {
    /**
     * 暴力枚举法，将子串作为key放入map 次数作为value
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> word_map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(s.length()<10){
            return res;
        }

        for (int i = 0; i < s.length(); i++) {
            if (i + 9 < s.length()) {
                String word = s.substring(i, i + 10);
                if (!word_map.containsKey(word)) {
                    word_map.put(word, 1);
                } else {
                    word_map.put(word, word_map.get(word) + 1);
                }
            }
        }

        Set<String> keySet = word_map.keySet();
        for (String tmp: keySet) {
            if(word_map.get(tmp)>1){
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s ="AAAAAAAAAAA";
        List<String> list = findRepeatedDnaSequences(s);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
