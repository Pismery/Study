package com.pismery.study.gof23.pattern.behavior.command.exercise;

public class OpenCommand implements Command {
    private BoardScreen screen = new BoardScreen();

    @Override
    public void excute() {
        screen.open();
    }
}
