package com.pismery.basic.vertify.inheritance;

public class Demo03 implements A3 {
    @Override
    public void doSth() {
        System.out.println("inside Demo03");
    }

    public static void main(String[] args) {
        new Demo03().doSth(); //inside Demo03
    }
}

interface A3 {
    default void doSth() {
        System.out.println("inside A");
    }
}