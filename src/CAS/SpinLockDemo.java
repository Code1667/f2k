package CAS;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wq
 * @date 2020-03-22 1:36
 */
public class SpinLockDemo {
    //原子引用
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");

        while (!atomicReference.compareAndSet(null, thread)){
            System.out.println(Thread.currentThread().getName()+"\t 正在尝试获取锁");
        }
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName()+"\t invoked unlock!");
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"t1").start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockDemo.myLock();
            System.out.println(Thread.currentThread().getName()+"\t 获取到锁了");
            spinLockDemo.myUnLock();
        },"t2").start();
    }
}
