package com.pismery.study.gof23.pattern.behavior.interator;

public class Client {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.createIterator();
        iterator.current();
        iterator.first();
        iterator.hasNext();
    }
}
