package com.pismery.study.gof23.pattern.behavior.template;

public class ConcreteClass extends AbstractClass {
    @Override
    protected boolean isDo() {
        return true;
    }
    @Override
    protected void operateB() {
        System.out.println("operateB is done");
    }
    @Override
    protected void operateA() {
        System.out.println("operateA is done");
    }
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templeteMethod();
    }
}
