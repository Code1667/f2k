package Classloader.testCL;

/**
 * @author wq
 * @date 2020-11-06 16:30
 */
public class Child extends People {
    String name;
    People people;


    public Child() {
        System.out.println("child无参");
    }

    public Child(String name) {
        System.out.println("child有参");
        this.name = name;
        people = new People(name);
    }


    public static void main(String[] args) {
        People c = new Child("aaa");
    }
}
