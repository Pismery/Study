package com.pismery.study.gof23.pattern.behavior.interator;

public class ConcreteAggregate implements Aggregate{
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}
