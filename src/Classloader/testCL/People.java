package Classloader.testCL;

/**
 * @author wq
 * @date 2020-11-06 16:26
 */
public class People {
    String name;

    public People() {
        System.out.println("People无参");
    }

    public People(String name) {
        System.out.println("People有参");
        this.name = name;
    }

    public void show(){
        System.out.println("peole");
    }
}
