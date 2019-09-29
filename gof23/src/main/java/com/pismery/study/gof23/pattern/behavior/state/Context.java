package com.pismery.study.gof23.pattern.behavior.state;

public class Context {
    private State state = new ConcreteStateA();

    public void dothing() {
        //做一些操作导致状态发生变化;
        state = new ConcreteStateB();
    }

    public void request() {
        state.handle();
    }
}
