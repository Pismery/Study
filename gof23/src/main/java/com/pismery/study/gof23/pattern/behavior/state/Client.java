package com.pismery.study.gof23.pattern.behavior.state;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.request();

        context.dothing();
        context.request();
    }
}