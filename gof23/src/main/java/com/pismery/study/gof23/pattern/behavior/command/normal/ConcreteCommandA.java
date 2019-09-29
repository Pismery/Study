package com.pismery.study.gof23.pattern.behavior.command.normal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteCommandA implements Command {
    private ReceiverA receiver = new ReceiverA();

    @Override
    public void excute() {
        receiver.action();
    }
}
