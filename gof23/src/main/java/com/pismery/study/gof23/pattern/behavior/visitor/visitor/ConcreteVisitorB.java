package com.pismery.study.gof23.pattern.behavior.visitor.visitor;

import com.pismery.study.gof23.pattern.behavior.visitor.element.ConcreteElementA;
import com.pismery.study.gof23.pattern.behavior.visitor.element.ConcreteElementB;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        log.debug("ConcreteVisitorB visit elementA");
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        log.debug("ConcreteVisitorB visit elementB");

    }
}
