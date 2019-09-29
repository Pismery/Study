package com.pismery.study.gof23.pattern.create.singleton;

public class IoDHSingleton {

    private IoDHSingleton() {
    }

    private static class Holder {
        private static final IoDHSingleton singleton = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance() {
        return Holder.singleton;
    }

}
