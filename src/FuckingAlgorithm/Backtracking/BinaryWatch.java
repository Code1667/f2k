package FuckingAlgorithm.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 401 二进制手表
 */
public class BinaryWatch {

    public static void main(String[] args) {
        List<String> strings = readBinaryWatch(1);
        System.out.println(strings);
    }

    //回溯法
    public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] times = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        dfs(num, res, times,0, 0, 0, 0);
        return res;
    }

    /**
     * @param num
     * @param res
     * @param times
     * @param count     已经用的数字个数
     * @param currIndex 当前索引
     * @param hour
     * @param minute
     */
    private static void dfs(int num, List<String> res, int[] times, int count, int currIndex, int hour, int minute) {
        if(hour>11 || minute>59){
            return;
        }

        if(count==num){
            res.add(culString(hour,minute));
            return;
        }

        for (int i = currIndex; i < times.length; i++) {
            //不放入
            dfs(num, res, times, count, currIndex+1, hour, minute);

            //放入
            if(currIndex<=3){
                hour += times[currIndex];
            }else {
                minute += times[currIndex];
            }
            dfs(num, res, times, count+1, currIndex+1, hour, minute);
            return;
        }
    }

    private static String culString(int hour, int minute) {
        StringBuilder sb = new StringBuilder();
        sb.append(hour).append(":");
        if(minute<10){
            sb.append(0);
        }
        sb.append(minute);
        return sb.toString();
    }


    //api方法
    public static List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return res;
    }
}
