package com.pismery.study.gof23.pattern.behavior.visitor;

import com.pismery.study.gof23.pattern.behavior.visitor.element.ConcreteElementA;
import com.pismery.study.gof23.pattern.behavior.visitor.element.ConcreteElementB;
import com.pismery.study.gof23.pattern.behavior.visitor.visitor.ConcreteVisitorA;
import com.pismery.study.gof23.pattern.behavior.visitor.visitor.ConcreteVisitorB;
import com.pismery.study.gof23.pattern.behavior.visitor.visitor.Visitor;

public class Client {
    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        structure.add(new ConcreteElementA());
        structure.add(new ConcreteElementB());

        Visitor visitorA = new ConcreteVisitorA();
        Visitor visitorB = new ConcreteVisitorB();

        structure.accept(visitorA);
        structure.accept(visitorB);
    }
}
