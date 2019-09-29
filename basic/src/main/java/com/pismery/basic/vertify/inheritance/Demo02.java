package com.pismery.basic.vertify.inheritance;

public class Demo02 implements A2, B2, C2 {
    @Override
    public void doSth() {
//        A2.super.doSth(); compile error
        C2.super.doSth();
    }

    public static void main(String[] args) {
        new Demo02().doSth(); //inside C
    }
}


interface A2 {
    default void doSth() {
        System.out.println("inside A");
    }
}

interface B2 {
}

interface C2 extends A2 {
    default void doSth() {
        System.out.println("inside C");
    }
}