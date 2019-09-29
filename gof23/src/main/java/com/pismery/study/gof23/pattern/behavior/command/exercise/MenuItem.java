package com.pismery.study.gof23.pattern.behavior.command.exercise;

public class MenuItem {
    private Command command;

    public MenuItem(Command command) {
        this.command = command;
    }

    public void click() {
        command.excute();
    }
}
