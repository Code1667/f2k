package Sort;

import java.io.*;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试耗时
 */
public class TimeTest {

    /**
     * 时间测试
     *
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws Exception {

        time("Bubble");//5214ms
        time("Heap");//21ms
        time("Insertion");//4345ms
        time("Merge");//13ms
        time("Selection");//5133ms
        time("Shell");//10ms
        //time("Quick"); stackOverFlowError
    }

    public static void time(String str) throws Exception {
        String fullStr = "Sort." + str;
        List<Integer> list = readFile();
        int[] a = list.stream().mapToInt(Integer::valueOf).toArray();
        //获取str的Class对象
        Class clazz = Class.forName(fullStr);
        Method sortMethod = clazz.getMethod("sort", int[].class);
        long start = System.currentTimeMillis();
        sortMethod.invoke(null, a);
        long end = System.currentTimeMillis();
        System.out.println(str + "算法耗时：" + (end - start) + "ms");
    }

    /**
     * 写10w个逆序数字到文件
     */
    public static void writeFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("reverse_array.txt"));
            for (int i = 100000; i >= 1; i--) {
                bw.write(i + "");
                if (i != 1) {
                    bw.write("\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读文件
     *
     * @return list
     */
    public static List<Integer> readFile() {
        List<Integer> list = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("reverse_array.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                int i = Integer.parseInt(line);
                list.add(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
