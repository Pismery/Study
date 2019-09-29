package com.pismery.study.gof23.pattern.behavior.command.exercise;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public void clickAllItem() {
        menuItems.stream().forEach(item -> item.click());
    }
}
