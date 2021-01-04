package JVM;

/**
 * @author wq
 * @date 2020-09-06 22:06
 */
public class VMTest {
    public static void main(String[] args) {
        //虚拟机试图使用的最大内存 默认分配电脑内存的1/4
        long max = Runtime.getRuntime().maxMemory();
        //jvm的初始化总内存 默认电脑内存的1/64
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max="+max+"字节\t" + (max/(double)1024/1024) + "MB");
        System.out.println("total="+total+"字节\t" + (total/(double)1024/1024) + "MB");

        //OOM:
        //1、尝试扩大内存看结果
        //2、分析内存，看哪里出现问题
        // -Xms1024m -Xmx1024m -XX:+PrintGCDetails
    }
}
