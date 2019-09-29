package com.pismery.study.gof23.pattern.structure.facade;

public class EncryptFacade implements  AbstractFacade{
    private Read read = new Read();
    private Encrypt encrypt = new Encrypt();
    private Write write = new Write();

    @Override
    public void encrypt(String path) {
        String inputStr = read.read(path);
        String encypt = encrypt.encrypt(inputStr);
        write.write(encypt);
    }
}
