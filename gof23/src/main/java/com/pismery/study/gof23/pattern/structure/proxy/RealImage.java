package com.pismery.study.gof23.pattern.structure.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        log.debug("Image is displaying...");
    }

    private void loadFromDisk(String  fileName) {
        log.debug("loading from disk...");
    }
}
