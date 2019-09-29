package com.pismery.study.gof23.pattern.behavior.visitor;

import com.pismery.study.gof23.pattern.behavior.visitor.element.Element;
import com.pismery.study.gof23.pattern.behavior.visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void add(Element element) {
        elements.add(element);
    }
    public void remove(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor) {
        elements.stream().forEach(e -> e.accepte(visitor));
    }
}
