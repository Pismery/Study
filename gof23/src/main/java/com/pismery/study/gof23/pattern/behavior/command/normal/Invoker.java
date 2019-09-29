package com.pismery.study.gof23.pattern.behavior.command.normal;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        command.excute();
    }
}
