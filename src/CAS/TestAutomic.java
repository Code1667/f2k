package CAS;

/**
 * @author wq
 * @date 2020-11-05 11:33
 */
public class TestAutomic {

    private int a = 0;

    public int add(){
        return a++;
    }

    public static void main(String[] args) {
        TestAutomic testAutomic = new TestAutomic();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   " + testAutomic.add());
                }
            }
        }).start();


        new Thread(){
            public void run(){
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   " + testAutomic.add());
                }

            }
        }.start();
    }
}
