package com.pismery.study.gof23.pattern.create.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

    public static void main(String[] args) {
        eagerSingleton();
        lazySingleton();
        ioDHSingleton();
        enumSingleton();
    }

    private static void eagerSingleton() {
        EagerSingleton e1 = EagerSingleton.getInstance();
        EagerSingleton e2 = EagerSingleton.getInstance();
        log.debug("EagerSingleton e1 == e2: " + String.valueOf(e1 == e2));
    }

    private static void lazySingleton() {
        LazySingleton e1 = LazySingleton.getInstance();
        LazySingleton e2 = LazySingleton.getInstance();
        log.debug("LazySingleton e1 == e2: " + String.valueOf(e1 == e2));
    }

    private static void ioDHSingleton() {
        IoDHSingleton e1 = IoDHSingleton.getInstance();
        IoDHSingleton e2 = IoDHSingleton.getInstance();
        log.debug("IoDHSingletonF e1 == e2: " + String.valueOf(e1 == e2));
    }

    private static void enumSingleton() {
        EnumSingleton e1 = EnumSingleton.ENUM_SINGLETON;
        EnumSingleton e2 = EnumSingleton.ENUM_SINGLETON;
        EnumSingleton e3 = EnumSingleton.valueOf("ENUM_SINGLETON");

        log.debug("EnumSingleton e1 == e2: " + String.valueOf(e1 == e2));
        log.debug("EnumSingleton e1 == e3: " + String.valueOf(e1 == e3));
    }

}
