package com.pismery.study.gof23.pattern.behavior.visitor.visitor;

import com.pismery.study.gof23.pattern.behavior.visitor.element.ConcreteElementA;
import com.pismery.study.gof23.pattern.behavior.visitor.element.ConcreteElementB;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        log.debug("ConcreteVistorA visit elementA");
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        log.debug("ConcreteVistorA visit elementB");

    }
}
