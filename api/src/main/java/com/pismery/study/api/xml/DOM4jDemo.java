package com.pismery.study.api.xml;

import com.pismery.study.api.xml.sax.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.dom4j.io.STAXEventReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DOM4jDemo {

    public static void main(String[] args) throws DocumentException, IOException, ParserConfigurationException, SAXException, XMLStreamException {
        Document document = getDocumentBySAX();
//        getBookByDocument(document);
        treeWalk(document.getRootElement());
    }

    private static Document getDocumentBySAX() throws DocumentException {
        SAXReader reader = new SAXReader();
        return reader.read(new File(DemoConstant.XML_PATH));
    }

    private static Document getDocumentByDOM() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse(new File(DemoConstant.XML_PATH));

        DOMReader reader = new DOMReader();
        return reader.read(document);
    }

    //当Xml文档中有注释会报XMLStreamException
    private static Document getDocumentBySTAX() throws FileNotFoundException, XMLStreamException {
        STAXEventReader reader = new STAXEventReader();
        return  reader.readDocument(new FileInputStream(DemoConstant.XML_PATH));
    }


    private static void treeWalk(Element element) {
        for (int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            if (node instanceof Element) {
                System.out.println("aaa");
                treeWalk((Element) node);
            }else {
                System.out.println(node.getNodeTypeName()+": "+node.getText());
            }
        }
    }

    private static void getBookByDocument(Document document) {
        Element root = document.getRootElement();
        List<Book> bookList = new ArrayList<>();
        for (Iterator<Element> iterator = root.elementIterator(); iterator.hasNext(); ) {
            Book book = new Book();
            Element element = iterator.next();
            book.setYear(Integer.valueOf(element.attributeValue("year")));
            for (Iterator<Element> elementIterator = element.elementIterator(); elementIterator.hasNext(); ) {
                Element elementSon = elementIterator.next();
                convertToBookAttribute(book, elementSon);
            }
            bookList.add(book);
        }
        bookList.stream().forEach(System.out::println);
    }

    private static void getEleByXPath(Document document) {
        List<Node> nodeList =  document.selectNodes("inventory/book/title");
        for (Node node : nodeList) {
            System.out.println(node.getName() + ": " + node.getText());
        }
    }

    private static void convertToBookAttribute(Book book, Element elementSon) {
        switch (elementSon.getName()) {
            case "title":
                book.setTitle(elementSon.getText());
                break;
            case "author":
                book.setAuthor(elementSon.getText());
                break;
            case "publisher":
                book.setPublisher(elementSon.getText());
                break;
            case "isbn":
                book.setIsbn(elementSon.getText());
                break;
            case "price":
                book.setPrice(elementSon.getText());
                break;
        }
    }
}
