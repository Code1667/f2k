package Interface;

/**
 * @author wq
 * @date 2020-11-06 15:23
 */
public class SubClass extends MyClass implements MyInterface1,MyInterface2{


    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.show();
    }

    @Override
    public void show() {
        System.out.println("sub");
    }
}
