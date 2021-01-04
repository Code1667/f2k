package ztest;

import java.util.HashMap;
import java.util.Map;

/**
 * 词典树
 */
public class TrieTree {
    
    private TNode root;

    public TrieTree() {
        root = new TNode('\u0000', new HashMap<Character, TNode>());
    }

    /**
     * 添加单词
     */
    public void add(String str) {
        TNode cur = root;
        if (root == null) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            TNode child = cur.nodeMap.get(str.charAt(i));
            if (child == null) {
                TNode node = new TNode(str.charAt(i), new HashMap<Character, TNode>());
                cur.nodeMap.put(str.charAt(i), node);
                cur = cur.nodeMap.get(str.charAt(i));
            } else {
                cur = child;
            }
        }
    }

    /**
     * 判断str是否存在
     *
     * @param str
     * @return
     */

    public boolean search(String str) {
        TNode cur = root;
        if (root == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            TNode child = cur.nodeMap.get(str.charAt(i));
            if (child == null) {
                return false;
            } else {
                cur = child;
            }
        }
        return true;
    }

}


/**
 * 树的节点类型
 */
class TNode {
    char ch;
    Map<Character, TNode> nodeMap;

    public TNode(char ch, Map<Character, TNode> nodeMap) {
        this.ch = ch;
        this.nodeMap = nodeMap;
    }
}