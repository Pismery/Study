package com.pismery.study.gof23.pattern.behavior.visitor.visitor;

import com.pismery.study.gof23.pattern.behavior.visitor.element.ConcreteElementA;
import com.pismery.study.gof23.pattern.behavior.visitor.element.ConcreteElementB;

public interface Visitor {
    void visit(ConcreteElementA concreteElementA);
    void visit(ConcreteElementB concreteElementB);
}
