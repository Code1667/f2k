package FuckingAlgorithm.Greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wq
 * @date 2020-03-28 23:46
 */
public class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {  //points {{1,2},{4,7}}
        if (points.length == 0) {
            return 0;   //传入的数据为空 直接返回0
        }
        //根据x_end 对气球排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;//默认射一箭
        int first_end = points[0][1];   //第一个气球宽度右边值
        int xstart, xend = points[0][1];
        for (int[] point : points) {    //遍历每个气球的坐标
            xstart = point[0];
            xend = point[1];
            if (first_end < xstart) {   //如果第一个气球的右宽度小于 遍历当前气球的起始值
                count++;
                first_end = xend;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        findMinArrowShots(points);
    }
}
