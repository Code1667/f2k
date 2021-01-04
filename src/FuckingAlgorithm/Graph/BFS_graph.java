package FuckingAlgorithm.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wq
 * @date 2020-04-09 10:11
 */
public class BFS_graph {

    public static void Bfs_graph(GraphNode node, int[] visit){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        visit[node.label] = 1;
        while (!queue.isEmpty()){
            GraphNode temp = queue.poll();
            System.out.print(temp.label);
            for (int i = 0; i < temp.neighbors.size(); i++) {
                if(visit[temp.neighbors.get(i).label]==0){
                    queue.add(temp.neighbors.get(i));
                    visit[temp.neighbors.get(i).label] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        int max_N = 5;
        GraphNode[] graphNodes = new GraphNode[max_N];
        for (int i = 0; i < max_N; i++) {
            graphNodes[i] = new GraphNode(i);
        }

        graphNodes[0].neighbors.add(graphNodes[4]);
        graphNodes[0].neighbors.add(graphNodes[2]);
        graphNodes[1].neighbors.add(graphNodes[0]);
        graphNodes[1].neighbors.add(graphNodes[2]);
        graphNodes[2].neighbors.add(graphNodes[3]);
        graphNodes[3].neighbors.add(graphNodes[4]);
        graphNodes[4].neighbors.add(graphNodes[3]);

        int[] visit = new int[max_N];
        for (int i = 0; i < max_N; i++) {
            if(visit[i] == 0){
                System.out.print("From label(" + i +")"+ ":" );
                Bfs_graph(graphNodes[i],visit);
                System.out.println();
            }
        }

    }
}
