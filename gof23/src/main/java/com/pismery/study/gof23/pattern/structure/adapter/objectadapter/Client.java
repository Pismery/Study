package com.pismery.study.gof23.pattern.structure.adapter.objectadapter;

import com.pismery.study.gof23.pattern.structure.adapter.classadapter.Adapter;
import com.pismery.study.gof23.pattern.structure.adapter.classadapter.Target;

public class Client {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.method();
    }
}
