package com.pismery.study.gof23.pattern.structure.composite.transparent;

public interface Component {
    void operate();
    void add(Component component);
    void delete(Component component);
    Component get(int index);
}
