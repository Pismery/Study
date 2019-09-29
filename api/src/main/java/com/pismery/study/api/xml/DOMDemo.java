package com.pismery.study.api.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class DOMDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(DemoConstant.XML_PATH));

        document.normalizeDocument(); //待理解用处

//        validate(pathname,document);

        NodeList nodeList = document.getElementsByTagName("book");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element)node;
                System.out.println("year: " + element.getAttribute("year"));
                System.out.println("title: " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("author: " + element.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("publisher: " + element.getElementsByTagName("publisher").item(0).getTextContent());
                System.out.println("isbn: " + element.getElementsByTagName("isbn").item(0).getTextContent());
                System.out.println("price: " + element.getElementsByTagName("price").item(0).getTextContent());
                System.out.println();
            }
        }

    }

    private static void validate(String filePath,Document document) throws IOException, SAXException {
        Schema schema = null;
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Validator validator = schema.newValidator();
        validator.validate(new DOMSource(document));
    }
}
