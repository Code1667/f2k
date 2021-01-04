package FuckingAlgorithm.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-04-09 10:10
 */
public class GraphNode {
    int label;
    List<GraphNode> neighbors;
    public GraphNode(int x){
        this.label = x;
        neighbors = new ArrayList<GraphNode>();
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "label=" + label +
                '}';
    }
}
