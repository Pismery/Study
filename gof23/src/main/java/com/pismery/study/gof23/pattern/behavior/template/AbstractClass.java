package com.pismery.study.gof23.pattern.behavior.template;

public abstract class AbstractClass {
    public final void templeteMethod() {
        System.out.println("before action");
        operateA();

        if (isDo())
            operateB();
        System.out.println("end action");
    }
    protected boolean isDo() {
        return false;
    }
    protected abstract void operateB();
    protected abstract void operateA();
}
