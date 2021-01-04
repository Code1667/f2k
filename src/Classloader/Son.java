package Classloader;

public class Son extends Father{
    private int i = test();

    private static int j = method();

    static {
        System.out.println("(6)子类静态代码块");
    }

    Son(){
        System.out.println("(7)子类无参构造器");
    }

    {
        System.out.println("(8)子类非静态代码块");
    }

    public int test() {
        System.out.println("(9)子类非静态属性 涉及到方法重写");
        return 1;
    }

    public static int method() {
        System.out.println("(10)子类静态属性");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
    }
}
