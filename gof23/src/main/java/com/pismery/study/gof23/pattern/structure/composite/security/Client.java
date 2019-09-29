package com.pismery.study.gof23.pattern.structure.composite.security;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        Component component = init();
        component.operate();
    }

    private static Component init() {
        Component composite1, composite2, leaf1, leaf2;

        composite1 = new Composite(new ArrayList<>());
        composite2 = new Composite(new ArrayList<>());

        leaf1 = new Leaf();
        leaf2 = new Leaf();

        ((Composite) composite1).add(leaf1);
        ((Composite) composite1).add(composite2);

        ((Composite) composite2).add(leaf2);
        return composite1;
    }
}
