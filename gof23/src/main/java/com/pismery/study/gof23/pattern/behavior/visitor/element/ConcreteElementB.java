package com.pismery.study.gof23.pattern.behavior.visitor.element;

import com.pismery.study.gof23.pattern.behavior.visitor.visitor.Visitor;

public class ConcreteElementB implements Element {

    @Override
    public void accepte(Visitor visitor) {
        visitor.visit(this);
    }
}
