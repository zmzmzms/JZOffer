package 设计模式;

public class Singleton {

    // 饿汉式： 在类加载的时候就创建一个实例，不管有没有用
    private static final Singleton instance = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance() {
        return instance;
    }


}
