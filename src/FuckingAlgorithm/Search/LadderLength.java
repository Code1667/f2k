package FuckingAlgorithm.Search;

import javafx.util.Pair;

import java.util.*;

/**
 * @author wq
 * @date 2020-05-02 10:47
 * leetcoce 127 单词接龙
 * 
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> graph = new HashMap<>();
        Map<String, List<String>> stringListMap = construct_graph(beginWord, wordList, graph);
        return BFS_graph(beginWord, endWord, stringListMap);
    }

    public int BFS_graph(String beginWord, String endWord, Map<String,List<String>> graph){
        Queue<Pair<String,Integer>> Q = new LinkedList<>();//搜索队列《顶点，步数》
        Set<String> visit = new HashSet<>();//记录已经访问的顶点
        Q.add(new Pair<>(beginWord, 1));//添加顶点和步数
        visit.add(beginWord);
        while (!Q.isEmpty()){
            Pair<String, Integer> poll = Q.poll();//队列头节点
            String node = poll.getKey();
            int step = poll.getValue();

            if (node.equals(endWord)){
                System.out.println(step);
                return step;
            }
            List<String> neighbors = graph.get(node);//和结果词不相等时候 获取该词的相通List
            for (int i = 0; i < neighbors.size(); i++) {
                String str = neighbors.get(i);
                if(!visit.contains(str)){
                    Q.add(new Pair<>(str, step+1));
                    visit.add(str);
                }
            }
        }
        return 0;
    }


    /**
     * 构造邻接表
     * @param beginWord
     * @param wordList
     * @param graph
     * @return
     */
    public Map<String,List<String>> construct_graph(String beginWord, List<String> wordList, Map<String,List<String>> graph){
        wordList.add(beginWord);

        for (int i = 0; i < wordList.size(); i++) {
            String string_i = wordList.get(i);
            graph.put(string_i, new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i+1; j < wordList.size(); j++) {
                //任意两个单词如果相差一个字符 则将其相连
                if(connect(wordList.get(i), wordList.get(j))){

                    List<String> string_listi = graph.get(wordList.get(i));
                    string_listi.add(wordList.get(j));

                    List<String> string_listj = graph.get(wordList.get(j));
                    string_listj.add(wordList.get(i));
                }
            }
        }
        return graph;
    }

    public boolean connect(String word1,String word2){
        int cnt = 0;//记录不相等字符数
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i)!=word2.charAt(i)){
                cnt++;
            }
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        LadderLength test = new LadderLength();
        test.ladderLength(beginWord, endWord, wordList);
    }
}
