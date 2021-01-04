package CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wq
 * @date 2020-03-21 10:47
 */
public class CASDemo {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        //main线程 do something...

        System.out.println(atomicInteger.compareAndSet(5, 2020) +  "\t currrent data: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1234) +  "\t currrent data: " + atomicInteger.get());
    }
}
