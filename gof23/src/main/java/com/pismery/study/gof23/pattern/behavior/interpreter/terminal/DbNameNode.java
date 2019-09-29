package com.pismery.study.gof23.pattern.behavior.interpreter.terminal;

import com.pismery.study.gof23.pattern.behavior.interpreter.AbstractNode;

public class DbNameNode implements AbstractNode {

    private String dbName;

    public DbNameNode(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String interpert() {
        return this.dbName;
    }
}
