package com.pismery.study.gof23.pattern.behavior.interpreter.terminal;

import com.pismery.study.gof23.pattern.behavior.interpreter.AbstractNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.KeyWord;

public class ToNode implements AbstractNode {

    private KeyWord keyword = KeyWord.TO;

    @Override
    public String interpert() {
        return "到";
    }
}
