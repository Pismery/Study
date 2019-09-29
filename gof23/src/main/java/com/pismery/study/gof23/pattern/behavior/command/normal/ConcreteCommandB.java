package com.pismery.study.gof23.pattern.behavior.command.normal;

public class ConcreteCommandB implements Command{
    private ReceiverB receiver = new ReceiverB();

    @Override
    public void excute() {
        receiver.action();
    }
}
