package com.pismery.study.gof23.pattern.structure.flyweight;

import lombok.Data;

@Data
public class OutStutas {
    private int positionX;
    private int positionY;
    private int size;


    public OutStutas(int positionX, int positionY, int size) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
    }
}
