package ztest;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        List<String> list = new ArrayList<String>();
//        list.add("hhh");
//        list.getClass().getMethod("add", Object.class).invoke(list, 111);
//        System.out.println(list.get(1));


        List aaa = new ArrayList();
        aaa.add(1);
        aaa.add(2);
        System.out.println("aaa->"+aaa);// aaa -> [1,2]
        List bbb = new ArrayList();
        bbb.add(1);
        bbb.add(2);
        bbb.add(3);
        System.out.println("bbb->"+bbb);//bbb->[1,2,3]

        List ccc = new ArrayList();
        ccc.add(aaa);
        ccc.add(bbb);
        System.out.println(ccc);

        List temp = (List) ccc.get(0);
        System.out.println("temp->"+temp);
        temp.add(3);
        System.out.println("修改后temp->"+temp);
        System.out.println("修改后aaa->"+aaa);


    }

}
