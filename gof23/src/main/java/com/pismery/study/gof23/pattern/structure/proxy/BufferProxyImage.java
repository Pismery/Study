package com.pismery.study.gof23.pattern.structure.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BufferProxyImage implements Image{

    private Image image;
    private String fileName;

    public BufferProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(this.image == null) {
            image = new RealImage(this.fileName);
        }
        image.display();
    }
}
