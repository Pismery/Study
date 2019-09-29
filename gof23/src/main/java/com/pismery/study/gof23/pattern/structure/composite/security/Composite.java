package com.pismery.study.gof23.pattern.structure.composite.security;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Composite implements Component {

    private List<Component> components;

    public Composite(List<Component> components) {
        if (components == null) {
            this.components = new ArrayList<>();
            return;
        }

        this.components = components;
    }

    @Override
    public void operate() {
        log.debug("Composite is operating...");
        components.stream().forEach(component -> {
            component.operate();
        });
    }

    public void add(Component component) {
        components.add(component);
    }

    public void delete(Component component) {
        components.remove(component);
    }

    public Component get(int index) {
        return components.get(index);
    }
}
