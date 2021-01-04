package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-09-06 22:40
 */
public class OOMTest2 {
    byte[] array = new byte[1*1024*1024];//1m
    public static void main(String[] args) {
        ArrayList<OOMTest2> list = new ArrayList<>();
        int count = 0;
        try {
            while(true){
                list.add(new OOMTest2());
                count +=1;
            }
        } catch (Error e) {
            System.out.println("count="+count);
            e.printStackTrace();
        }
    }
}
