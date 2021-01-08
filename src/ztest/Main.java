package ztest;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<String>();
        list.add("hhh");
        list.getClass().getMethod("add", Object.class).invoke(list, 111);
        System.out.println(list.get(1));


    }

}
