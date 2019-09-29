package com.pismery.study.gof23.pattern.behavior.interpreter.terminal;

import com.pismery.study.gof23.pattern.behavior.interpreter.AbstractNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.KeyWord;

public class OperationNode implements AbstractNode {

    private KeyWord operarion;

    public OperationNode(KeyWord operarion) {
        this.operarion = operarion;
    }

    @Override
    public String interpert() {
        switch (this.operarion) {
            case MOVE:
                return "移动";
            case COPY:
                return "复制";
            default:
                throw new RuntimeException();
        }
    }
}
