package JVM;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ContainerBlockingQueue {
    BlockingQueue<Object> queue = new LinkedBlockingQueue<>(5);
 
    public void put(Object obj) {
        // 如果队列是满的话，会阻塞当前线程
        try {
            queue.put(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public Object take() {
        Object result = null;
        try {
            // 如果队列为空，会阻塞当前线程
            result = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
 
    public static void main(String[] args) {
        ContainerBlockingQueue blockQueue = new ContainerBlockingQueue();
        // 启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println("消费者" + Thread.currentThread().getName() + "，获取数据为：" + blockQueue.take());
                }
            }, "consumer" + i).start();
        }
 
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // 启动生产者线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    int data = (int) (Math.random() * 1000);
                    blockQueue.put(data);
                    System.out.println("生产者" + Thread.currentThread().getName() + "，存放数据为：" + data);
                }
            }, "producer" + i).start();
        }
    }
}