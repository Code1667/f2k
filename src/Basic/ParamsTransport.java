package Basic;

import java.util.Arrays;

/**
 * 测试参数传递
 *
 * @author falcon
 */
public class ParamsTransport {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();

        change(i, str, num, arr, my);

        System.out.println("i=" + i);//1
        System.out.println("str=" + str);//hello
        System.out.println("num=" + num);//200
        System.out.println("arr=" + Arrays.toString(arr));//2
        System.out.println("my=" + my.a);//11
    }

    public static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}
