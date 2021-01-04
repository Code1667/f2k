package Singelton;

/**
 * 双重锁监测
 */
public class doubleLockedSingleton {
    private static volatile doubleLockedSingleton instance;

    private doubleLockedSingleton(){

    }

    public doubleLockedSingleton getInstance(){
        if(instance==null){
            synchronized (doubleLockedSingleton.class){
                if(instance==null){
                    instance = new doubleLockedSingleton();
                }
            }
        }
        return instance;
    }
}
