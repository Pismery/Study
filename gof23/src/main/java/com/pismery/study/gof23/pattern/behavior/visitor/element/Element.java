package com.pismery.study.gof23.pattern.behavior.visitor.element;

import com.pismery.study.gof23.pattern.behavior.visitor.visitor.Visitor;

public interface Element {
    void accepte(Visitor visitor);
}
