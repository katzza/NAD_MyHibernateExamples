package a_qg.singleton;

public class SingletonL {
    private static SingletonL instance = null;
    private SingletonL() {
    }
    public static synchronized SingletonL getInstance() { //! synchronized
        if (instance == null) {
            instance = new SingletonL();
        }
        return instance;
    }

}
/*
       + Ленивая инициализация
       - Низкая производительность (критическая секция) в наиболее типичном доступе*/
