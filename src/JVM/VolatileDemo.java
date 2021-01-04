package JVM;

import java.util.concurrent.atomic.AtomicInteger;

class MyData {

    volatile int num = 0;

    public void To60() {
        this.num = 60;
    }

    public void add() {
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void AtomicAdd(){
        atomicInteger.getAndAdd(1);
    }
}


public class VolatileDemo {
    public static void main(String[] args) {

        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {//创建20个线程
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {//每个线程1000次+1操作
                    myData.add();
                    myData.AtomicAdd();
                }
            }, String.valueOf(i)).start();
        }

        //默认main线程和GC线程，其余是我们创建的
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        //非默认线程执行完后
        System.out.println("misson is over num = " + myData.num);
        System.out.println("misson is over atomicInteger = " + myData.atomicInteger);
        seeAble();
    }


    //验证可见性
    private static void seeAble() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.To60();

            System.out.println(Thread.currentThread().getName() + "\t update num value: " + myData.num);
        }, "t1").start();

        //第二个线程是main
        while (myData.num == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t misson is over: " + myData.num);
    }
}
