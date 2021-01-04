package Classloader;


public class Father {
    private int i= test();

    private static int j=method();

    static {
        System.out.println("(1)父类静态代码块");
    }

    Father() {
        System.out.println("(2)父类无参构造器");
    }

    {
        System.out.println("(3)父类非静态代码块");
    }

    public int test() {
        System.out.println("(4)父类非静态属性");
        return 1;
    }

    public  static int method() {
        System.out.println("(5)父类静态属性");
        return 1;
    }
}
