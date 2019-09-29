package com.pismery.study.api.xml.sax;

import com.pismery.study.api.xml.DemoConstant;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class SAXDemo {
    public static void main(String[] args) throws SAXException, IOException {
        UserParserHandle handle = new UserParserHandle();

        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handle);
        reader.parse(new InputSource(new FileInputStream(DemoConstant.XML_PATH)));
    }
}
