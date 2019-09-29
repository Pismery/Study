package com.pismery.study.gof23.pattern.behavior.command.normal;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker(new ConcreteCommandA());
        invoker.call();

        invoker = new Invoker(new ConcreteCommandB());
        invoker.call();
    }
}
