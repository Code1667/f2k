package FuckingAlgorithm.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * leetcode 451 根据字符出现频率排序
 */
public class FrequencySort {

    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<Character>(((o1, o2) -> (map.get(o2)-map.get(o1))));
        for (Character character : map.keySet()) {
            queue.add(character);
        }
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            Character tmp = queue.poll();
            for (int i = 0; i < map.get(tmp); i++) {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }


    //哈希表+大根堆
    public static String frequencySort2(String s) {
        int[] letters = new int[128];
        for (char c : s.toCharArray()) letters[c]++;

        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) {
                heap.offer((char)i);
            }
        }

        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c]-- > 0) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "AabbCCC";
        String res = frequencySort2(s);
        System.out.println(res);

    }
}
