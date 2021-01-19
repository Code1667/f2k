package AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author wq
 * @date 2021-01-18 16:19
 */
public class SimpleLock extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public void lock() {
        acquire(1);
    }

    public boolean tryLock() {
        return tryAcquire(1);
    }

    public void unlock() {
        release(1);
    }


    public static void main(String[] args) throws InterruptedException {
        final SimpleLock lock = new SimpleLock();
        lock.lock();
        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " -> acquired the lock!");
                lock.unlock();
            },String.valueOf(i)).start();

            // 简单的让线程按照for循环的顺序阻塞在lock上
            //目的是让线程顺序启动
            Thread.sleep(100);
        }

        System.out.println("main thread unlock!");
        lock.unlock();

    }
}
