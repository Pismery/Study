package com.pismery.study.gof23.pattern.behavior.interpreter.nonterminal;

import com.pismery.study.gof23.pattern.behavior.interpreter.AbstractNode;

public class ExpressionNode implements AbstractNode {

    private AbstractNode operationNode;
    private AbstractNode aimNode;
    private AbstractNode directionNode;

    public ExpressionNode(AbstractNode operationNode, AbstractNode aimNode, AbstractNode directionNode) {
        this.operationNode = operationNode;
        this.aimNode = aimNode;
        this.directionNode = directionNode;
    }

    @Override
    public String interpert() {
        return operationNode.interpert() + aimNode.interpert() + directionNode.interpert();
    }
}
