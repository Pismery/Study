package com.pismery.study.gof23.pattern.behavior.command.exercise;

public class Client {
    public static void main(String[] args) {
        Menu menu = initMenu();
        menu.clickAllItem();
    }

    private static Menu initMenu() {
        Menu menu  = new Menu();
        MenuItem craeteItem = new MenuItem(new CreateCommand());
        MenuItem editItem = new MenuItem(new EditCommand());
        MenuItem openItem = new MenuItem(new OpenCommand());

        menu.addItem(craeteItem);
        menu.addItem(editItem);
        menu.addItem(openItem);
        return menu;
    }
}
