package Singelton;

/**
 * 静态内部类实现方式
 * ClassLoader加载静态内部类自带线程安全
 * 懒加载
 */
public class inClassSingleton {

    private inClassSingleton(){

    }

    private static class InstanceClass{
        private final static inClassSingleton instance = new inClassSingleton();
    }

    public inClassSingleton getInstance(){
        return InstanceClass.instance;
    }
}
