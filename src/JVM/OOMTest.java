package JVM;

import java.util.Random;

/**
 * @author wq
 * // -Xms8m -Xmx8m -XX:+PrintGCDetails
 */
public class OOMTest {
    public static void main(String[] args) {
        String str = "kuangshensayjava";

        while(true){
            str += str + new Random().nextInt(888888888)+new Random().nextInt(999999999);
        }
    }
}
