package a_qg.singleton;

public class SingletonL2 {
    private static SingletonL2 instance = null;
    private static final Object lock = new Object();
    private static boolean isInitialized = false;

    public static SingletonL2 getInstance() {
        if (!isInitialized) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new SingletonL2();
                    isInitialized = true;
                }
            }
        }
        return instance;
    }
}

