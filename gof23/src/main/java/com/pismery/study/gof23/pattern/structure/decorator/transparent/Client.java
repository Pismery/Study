package com.pismery.study.gof23.pattern.structure.decorator.transparent;

public class Client {

    public static void main(String[] args) {
        Componet componet = initListPanel();
        componet.display();

        componet = initTextPanel();
        componet.display();
    }

    private static Componet initListPanel() {
        return new ToolbarDecorator(new BlackBorderDecorator(new ListPanel()));
    }
    private static Componet initTextPanel() {
        return new ToolbarDecorator(new BlackBorderDecorator(new TextPanel()));
    }
}
