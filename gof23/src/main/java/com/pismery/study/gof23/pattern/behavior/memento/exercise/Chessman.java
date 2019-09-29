package com.pismery.study.gof23.pattern.behavior.memento.exercise;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Chessman {
    private String name;
    private int positionX;
    private int positionY;

    public Chessman(String name, int positionX, int positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Chessman(Chessman chessman) {
        this.name = chessman.name;
        this.positionX = chessman.positionX;
        this.positionY = chessman.positionY;
    }

    public void move(int x,int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public Memento save(){
        return new Memento(this);
    }

    public void reverse(Object memento){
        this.name = ((Memento)memento).chessman.name;
        this.positionX = ((Memento)memento).chessman.positionX;
        this.positionY = ((Memento)memento).chessman.positionY;
    }

    private class Memento{
        private Chessman chessman;

        public Memento(Chessman chessman) {
            this.chessman = new Chessman(chessman);
        }
        public void setChessman(Chessman chessman) {
            this.chessman = new Chessman(chessman);
        }
    }
}
