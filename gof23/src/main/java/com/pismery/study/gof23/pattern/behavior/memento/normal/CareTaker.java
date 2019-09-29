package com.pismery.study.gof23.pattern.behavior.memento.normal;

import java.util.ArrayList;
import java.util.List;

public class CareTaker  {
    private List<Memento> list = new ArrayList<>();

    public void add(Memento memento) {
        list.add(memento);
    }

    public Memento get(int index) {
        return list.get(index);
    }
}
