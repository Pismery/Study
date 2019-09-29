package com.pismery.study.gof23.pattern.create.singleton;

public enum EnumSingleton {
    ENUM_SINGLETON;

    EnumSingleton() {
    }

    public EnumSingleton getSingleton() {
        return this;
    }
}
