package com.pismery.study.gof23.pattern.behavior.observer.jdk;

import lombok.ToString;

import java.util.Observable;

@ToString
public class Subject extends Observable {
    private  String  status;

    public Subject(String status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;

        setChanged();//必须添加
        notifyObservers(status);
    }
}
