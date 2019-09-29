package com.pismery.study.gof23.pattern.structure.decorator.transparent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlackBorderDecorator extends Decorator{

    public BlackBorderDecorator(Componet component) {
        super(component);
    }

    @Override
    public void display() {
        component.display();
        setBlackBorder();
    }

    private void setBlackBorder() {
        log.debug("BlackBorderDecorator set compont black border...");
    }
}
