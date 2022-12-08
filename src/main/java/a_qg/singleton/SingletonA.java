package a_qg.singleton;

public class SingletonA {
    public static final SingletonA INSTANCE = new SingletonA();
}

/*      + Простая и прозрачная реализация
        + Потокобезопасность
        - Не ленивая инициализация */