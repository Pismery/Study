package com.pismery.study.gof23.pattern.behavior.interator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteIterator implements Iterator{

    private ConcreteAggregate aggregate;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public ConcreteAggregate first() {
        log.debug("ConcreteAggregate first....");
        return null;
    }

    @Override
    public boolean hasNext() {
        log.debug("ConcreteAggregate hasNext....");
        return false;
    }

    @Override
    public ConcreteAggregate current() {
        log.debug("ConcreteAggregate current....");
        return null;
    }
}
