package com.pismery.study.gof23.pattern.create.singleton;

public class LazySingleton {
    private volatile static LazySingleton singleton;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
               if(singleton == null)
                   singleton = new LazySingleton();
            }
        }
        return singleton;
    }
}
