package com.pismery.study.gof23.pattern.behavior.interpreter.nonterminal;

import com.pismery.study.gof23.pattern.behavior.interpreter.AbstractNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.terminal.FromNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.terminal.ToNode;

public class DirectionNode implements AbstractNode {
    private AbstractNode fromNode = new FromNode();
    private AbstractNode toNode = new ToNode();
    private AbstractNode dbFrom;
    private AbstractNode dbTo;

    public DirectionNode(AbstractNode dbFrom, AbstractNode dbTo) {
        this.dbFrom = dbFrom;
        this.dbTo = dbTo;
    }

    @Override
    public String interpert() {
        return fromNode.interpert() + dbFrom.interpert() + toNode.interpert() + dbTo.interpert();
    }
}
