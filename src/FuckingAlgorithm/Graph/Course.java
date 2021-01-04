package FuckingAlgorithm.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wq
 * @date 2020-04-09 21:34
 */
public class Course {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphNode[] graphNodes = new GraphNode[numCourses];
        int[] visit = new int[numCourses];

        //创建图节点，并且访问状态赋值未完成
        for (int i = 0; i < numCourses; i++) {
            graphNodes[i] = new GraphNode(i);
            visit[i] = -1;  //-1为未完成，0为正在完成，1为已完成
        }
        //连接图
        for (int i = 0; i < prerequisites.length; i++) {
            GraphNode first = graphNodes[prerequisites[i][0]];
            GraphNode second = graphNodes[prerequisites[i][1]];
            first.neighbors.add(second);//课程1指向课程2：想学课程2 必须先学课程1
        }

        for (int i = 0; i < graphNodes.length; i++) {
            if (visit[i] == -1 && !DFS_graph(graphNodes[i], visit)) {
                return false; //如果没完成，进行DFS，如果DFS遇到环无法完成
            }
        }
        return true;
    }

    public boolean DFS_graph(GraphNode node, int[] visit) {
        visit[node.label] = 0;
        for (int i = 0; i < node.neighbors.size(); i++) {
            if (visit[node.neighbors.get(i).label] == -1) {
                if (!DFS_graph(node.neighbors.get(i), visit)) {
                    return false;
                }
            } else if (visit[node.neighbors.get(i).label] == 0) {
                return false;
            }
        }
        visit[node.label] = 1;
        return true;
    }


    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        GraphNode[] graphNodes = new GraphNode[numCourses];
        int[] degree = new int[numCourses];//入度数组


        //创建图节点，并且访问状态赋值未完成
        for (int i = 0; i < numCourses; i++) {
            degree[i] = 0;  //0可入队列，1有一个依赖，2有两个依赖
            graphNodes[i] = new GraphNode(i);
        }
        //连接图
        for (int i = 0; i < prerequisites.length; i++) {
            GraphNode begin = graphNodes[prerequisites[i][0]];  //课程1
            GraphNode end = graphNodes[prerequisites[i][1]];    //课程2
            begin.neighbors.add(end);//课程1指向课程2：想学课程2 必须先学课程1
            degree[prerequisites[i][1]]++;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(degree[i]==0){
                queue.add(graphNodes[i]);
            }
        }
        while (!queue.isEmpty()){
            GraphNode node = queue.poll();
            for (int i = 0; i < node.neighbors.size(); i++) {
                degree[node.neighbors.get(i).label]--;
                if(degree[node.neighbors.get(i).label] == 0){
                    queue.add(node.neighbors.get(i));
                }
            }
        }
        for (int i = 0; i < degree.length; i++) {
            if(degree[i]!=0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
