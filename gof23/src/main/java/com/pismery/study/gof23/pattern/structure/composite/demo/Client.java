package com.pismery.study.gof23.pattern.structure.composite.demo;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        Component window = init();
        window.display();
    }

    private static Component init() {
        Component window,panel,button1,button2,text1,text2;

        window = new Window(new ArrayList<>());
        panel = new MiddlePanel(new ArrayList<>());

        button1 = new Button();
        button2 = new Button();
        text1 = new Text();
        text2 = new Text();

        window.add(button1);
        window.add(text1);
        window.add(panel);

        panel.add(button2);
        panel.add(text2);
        return window;
    }
}
