package JVM;

/**
 * 本地方法测试
 * @author wq
 * @date 2020-09-06 16:28
 */
public class NativeTest {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            new NativeTest().start0();
        },"自建线程").start();

    }

    //凡是带了native关键字的，说明java达不到，回去调用底层C语言库
    //会进入本地方法栈
    //调用本地方法接口 Java Native Interface
    //JNI作用：扩展java的使用 融合不同编程语言
    //在java创建初期想在C、C++横行的年代立足，所以开辟了本地方法栈
    private native void start0();

}
