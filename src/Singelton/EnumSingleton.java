package Singelton;

/**
 * 枚举实现单例模式
 *   优点：实现简单
 *   	   枚举本身就是单例
 *   	   JVM从根本提供保障，避免反射和反序列化的漏洞
 *   缺点：无法延时加载
 */
public enum  EnumSingleton {
    INSTANCE;
    public void doSomthing(){
        //...
    }
}
