package AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author wq
 * @date 2021-01-18 16:29
 */
public class MyLock implements Lock {
    Sync sync = new Sync();

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }


    private class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if(state==0){
                if (compareAndSetState(0, arg)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }else if(getExclusiveOwnerThread()==Thread.currentThread()){
                setState(state+arg);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(Thread.currentThread()!=getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state = getState() - arg;
            setState(state);
            if(state==0){
                setExclusiveOwnerThread(null);
                return true;
            }
            return false;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }
}
