package com.pismery.study.gof23.pattern.behavior.interpreter.nonterminal;

import com.pismery.study.gof23.pattern.behavior.interpreter.AbstractNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.KeyWord;

public class AimNode implements AbstractNode {

    private KeyWord keyWord;
    private AbstractNode dbName;

    public AimNode(KeyWord keyWord, AbstractNode dbName) {
        this.keyWord = keyWord;
        this.dbName = dbName;
    }

    @Override
    public String interpert() {
        switch (keyWord) {
            case TABLE:
                return "表" + dbName.interpert();
            case VIEW:
                return "所有视图";
            default:
                throw new RuntimeException();
        }
    }
}
