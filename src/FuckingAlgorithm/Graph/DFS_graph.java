package FuckingAlgorithm.Graph;

/**
 * @author wq
 * @date 2020-04-09 10:11
 */
public class DFS_graph {

    public static void Dfs_graph(GraphNode node, int[] visit){
        visit[node.label] = 1;
        System.out.print(node.label);
        for (int i = 0; i < node.neighbors.size(); i++) {
            if(visit[node.neighbors.get(i).label]==0){
                Dfs_graph(node.neighbors.get(i),visit);
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
                Dfs_graph(graphNodes[i],visit);
                System.out.println();
            }
        }

    }
}
