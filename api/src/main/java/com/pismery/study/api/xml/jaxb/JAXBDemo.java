package com.pismery.study.api.xml.jaxb;

import com.pismery.study.api.xml.DemoConstant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBDemo {
    public static void main(String[] args) throws JAXBException {
        File xml = new File(DemoConstant.XML_PATH);
        JAXBContext context = JAXBContext.newInstance(Inventory.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Inventory inventory = (Inventory)unmarshaller.unmarshal(xml);
        inventory.getBookList().forEach(System.out::println);
    }
}
