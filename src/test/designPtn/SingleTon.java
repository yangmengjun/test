package test.designPtn;
/**
 * 单例模式
 * @author Json
 *
 */
public class SingleTon {
    private final static SingleTon instance = new SingleTon();

    private SingleTon() {

    }

    public SingleTon getInstance() {
        return instance;
    }
}

class SingleTon2 {
    public static SingleTon2 instance = null;

    public static synchronized SingleTon2 getInstance() {
        if (instance == null) {
            return new SingleTon2();
        }
        return instance;
    }
}