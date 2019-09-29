package com.pismery.study.gof23.pattern.structure.composite.demo;

public interface Component {
    void display();
    void add(Component component);
    void delete(Component component);
    Component get(int index);
}
