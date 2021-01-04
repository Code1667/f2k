package FuckingAlgorithm.Heap;

import java.util.*;

/**
 * leetcode 692 前k个高频单词
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        List<String> strings = topKFrequent2(words, 2);
        System.out.println(strings);
    }


    /**
     * 排序
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        List<String> res = new ArrayList<>(map.keySet());
        Collections.sort(res,(o1,o2)->map.get(o1).equals(map.get(o2))?
                o1.compareTo(o2):map.get(o2)-map.get(o1));
        return res.subList(0, k);
    }

    /**
     * 堆
     */
    public static List<String> topKFrequent2(String[] words, int k) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        //创建小根堆
        PriorityQueue<String> queue = new PriorityQueue<>(((o1, o2) -> map.get(o1).equals(map.get(o2))?
                o2.compareTo(o1):map.get(o1) - map.get(o2)));

        for (String s : map.keySet()) {
            queue.add(s);
            if(queue.size()>k){
                queue.poll();
            }
        }


        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }

        Collections.reverse(res);
        return res;
    }


}
