package com.pismery.study.gof23.pattern.structure.decorator.transparent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ToolbarDecorator extends Decorator {
    public ToolbarDecorator(Componet component) {
        super(component);
    }

    @Override
    public void display() {
        component.display();
        setToolbar();
    }

    private void setToolbar() {
        log.debug("ToolbarDecorator set compont toolbar...");
    }
}
