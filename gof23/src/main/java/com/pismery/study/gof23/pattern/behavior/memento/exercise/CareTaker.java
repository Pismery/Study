package com.pismery.study.gof23.pattern.behavior.memento.exercise;

import lombok.Data;

import java.util.Stack;

@Data
public class CareTaker {
    private Stack<Object> mementoStack = new Stack<>();
    private Stack<Object> reReverseStack = new Stack<>();

    public void add(Object memento) {
        mementoStack.push(memento);
    }

    public Object reverse() {
        reReverseStack.push(mementoStack.pop());
        return mementoStack.peek();
    }

    public Object reReverse() {
        Object result =  reReverseStack.pop();
        mementoStack.push(result);
        return result;
    }
}
