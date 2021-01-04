package FuckingAlgorithm.BFS;

import java.util.*;

/**
 * @author wq
 * @date 2020-12-15 21:36
 */
public class CourseSchedule {
    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int[][] prerequisites4 = {{1, 0}, {2, 0}};
        int[][] prerequisites3 = {};


        boolean b = canFinish(3, prerequisites4);
        System.out.println(b);

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Integer> map = new HashMap<>();

        //[a,b]
        //添加课程进map
        for (int i = 0; i < prerequisites.length; i++) {
            map.put(prerequisites[i][0], prerequisites[i][1]);
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < prerequisites.length; i++) {
            Integer course1 = prerequisites[i][0];
            Integer course2 = map.get(course1);

            if (!map.containsKey(course2)) {
                if (!set.contains(course1)) {
                    numCourses--;
                    set.add(course1);
                }
                if (!set.contains(course2)) {
                    numCourses--;
                    set.add(course2);
                }
            } else if (map.containsKey(course2) && map.get(course2) == course1) {
                continue;
            }
        }
        if (numCourses == 0) {
            return true;
        } else {
            return numCourses > prerequisites.length ? true : false;
        }
    }


    //------------入度的方式理解-------------
    //题目：[1,0] 想读1，必须先读0，即读了0才能读1，
    //那么如果有一个这样数组的就说明读1 有一个条件是读0，假如有[1,2]那么读1的条件又增加了一个就是读2
    //所以读1 的条件有两个，所以1的入度为2
    //用一个list存放读了i才能读的列表 如果列表中的入度（先决条件个数为0）那么就可以读
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        //存放入度的数组
        int[] arr = new int[numCourses];

        //如[a,b]  建立存放读了b才能读的列表
        List<List<Integer>> list = new ArrayList<>();
        //初始化
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
            //入度+1
            arr[prerequisite[0]]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        for (int i = 0; i < arr.length; i++) {
            //入读为0，说明不需要读别的书
            if(arr[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            Integer b = queue.poll();
            visited++;
            //[a,b] 想要学a  先学b  将a的入度-1
            for (Integer a : list.get(b)) {
                arr[a]--;
                if(arr[a]==0){
                    queue.offer(a);
                }
            }
        }
        return visited == numCourses;
    }
}
