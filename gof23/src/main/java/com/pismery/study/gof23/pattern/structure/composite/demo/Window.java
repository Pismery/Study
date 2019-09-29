package com.pismery.study.gof23.pattern.structure.composite.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Window implements Component {
    private List<Component> components;

    public Window(List<Component> components) {
        if (components == null) {
            this.components = new ArrayList<>();
            return;
        }

        this.components = components;
    }

    @Override
    public void display() {
        log.debug("Window is displaying...");
        this.components.stream().forEach(component -> component.display());
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void delete(Component component) {
        components.remove(component);
    }

    @Override
    public Component get(int index) {
        return components.get(index);
    }
}
