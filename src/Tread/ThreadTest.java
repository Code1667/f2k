package Tread;

/**
 * 两个线程交替打印
 *
 */
public class ThreadTest implements Runnable {

    private static int i = 1;
    //synchronized锁对象
    private final Object o = new Object();

    @Override
    public void run() {
        while (i <= 100) {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + ",我打印出了" + i);
                i++;
                //打印完成之后 唤醒另外一个线程
                o.notify();
                try {
                    //唤醒另外一个线程之后，调用wait() 释放synchronized锁 并进入blocking状态
                    //只有这样才能保证另外一个线程能获取到synchronized锁 并往下执行 实现交替打印
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("ERROR");
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        Thread thread1 = new Thread(t, "线程1");
        Thread thread2 = new Thread(t, "线程2");
        thread1.start();
        thread2.start();

    }

}
