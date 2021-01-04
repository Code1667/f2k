package FuckingAlgorithm.DFS;

import java.util.*;

/**
 * leetcode 559 N叉数的最大深度
 */
public class MaximumDepthofNaryTree {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        List<Node> n1ch = Arrays.asList(n2,n3,n4);
        List<Node> n3ch = Arrays.asList(n5,n6);

        n1.children = n1ch;
        n3.children = n3ch;


        int i = maxDepth(n1);
        System.out.println(i);


    }


    //------------迭代—-------------------
    public static int maxDepth(Node root) {
        if (root==null){
            return 0;
        }
        Queue<Node> queue = new LinkedList();
        Map<Node,Integer> map = new HashMap<>();
        queue.add(root);
        int maxDepth = 0;
        int currDepth = 0;
        map.put(root, ++currDepth);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            maxDepth = maxDepth>map.get(node)?maxDepth:map.get(node);
            List<Node> children = node.children;
            if (children!=null){
                children.forEach(a ->{
                    map.put(a, map.get(node)+1);
                    queue.add(a);
                });
            }
            map.remove(node);
        }
        return maxDepth;
    }

    //--------------递归--------------------
    public static int maxDepth2(Node root) {
        if(root==null){
            return 0;
        }
        int maxDepth = 1;
        for (Node node:root.children) {
            maxDepth = Math.max(maxDepth, maxDepth2(node)+1);
        }
        return maxDepth;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};