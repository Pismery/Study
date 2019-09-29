package com.pismery.study.gof23.pattern.behavior.interpreter.terminal;

import com.pismery.study.gof23.pattern.behavior.interpreter.AbstractNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.KeyWord;

public class FromNode implements AbstractNode {

    private KeyWord keyWord = KeyWord.FROM;

    @Override
    public String interpert() {
        return "从";
    }
}
