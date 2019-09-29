package com.pismery.study.gof23.pattern.structure.adapter.classadapter;

public class Client {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.method();
    }
}
