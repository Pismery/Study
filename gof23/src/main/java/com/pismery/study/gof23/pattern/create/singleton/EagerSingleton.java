package com.pismery.study.gof23.pattern.create.singleton;

public class EagerSingleton {

    private static final EagerSingleton singleton = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return singleton;
    }
}
