package 设计模式;

public class Singleton2 {
    // 饱汉式：在使用时再创建，为了避免有两个调用导致创建两份要加锁
    private static Singleton2 instance;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
