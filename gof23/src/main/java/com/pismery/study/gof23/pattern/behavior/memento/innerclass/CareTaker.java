package com.pismery.study.gof23.pattern.behavior.memento.innerclass;

import java.util.ArrayList;
import java.util.List;

public class CareTaker  {
    private List<Object> list = new ArrayList<>();

    public void add(Originator originator) {

        list.add(originator.save());
    }

    public Object get(int index) {
        return list.get(index);
    }
}
