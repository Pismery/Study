package com.pismery.study.gof23.pattern.structure.facade;

public class Client {
    public static void main(String[] args) {
        AbstractFacade encrpty = new EncryptFacade();
        encrpty.encrypt("path");
    }
}
