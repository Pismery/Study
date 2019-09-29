package com.pismery.basic.vertify.inheritance;

public class Demo01 implements B, A  {
    @Override
    public void doSth() {
        A.super.doSth();
        B.super.doSth();
    }

    public static void main(String[] args) {
        new Demo01().doSth(); //inside A /n inside B
    }


}
interface A {
    default void doSth() {
        System.out.println("inside A");
    }
}
interface B {
    default void doSth() {
        System.out.println("inside B");
    }
}