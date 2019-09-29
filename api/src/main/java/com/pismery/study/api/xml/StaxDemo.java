package com.pismery.study.api.xml;

import com.pismery.study.api.xml.sax.Book;
import com.sun.xml.internal.stream.events.AttributeImpl;

import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxDemo {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        System.out.println("Demo01");
        demo01();
        System.out.println("Demo02");
        demo02();
        System.out.println("Demo03");
        demo03();
    }

    // Iterator Api
    private static void demo03() throws FileNotFoundException, XMLStreamException {
        XMLEventReader reader = getXmlEventReader();

        XMLEvent event;
        List<Book> bookList = new ArrayList<>();
        for (Book book = null; reader.hasNext(); ) {
            event = reader.nextEvent();
            if (event.isStartElement()) {
                switch (event.asStartElement().getName().getLocalPart()) {
                    case "book":
                        book = new Book();
                        //属性需要通过AttributeImpl转换
                        AttributeImpl attribute = (AttributeImpl) event.asStartElement().getAttributes().next();
                        book.setYear(Integer.parseInt(attribute.getValue()));
                        break;
                    case "title":
                        book.setTitle(reader.getElementText());
                        break;
                    case "author":
                        book.setAuthor(reader.getElementText());
                        break;
                    case "publisher":
                        book.setPublisher(reader.getElementText());
                        break;
                    case "isbn":
                        book.setIsbn(reader.getElementText());
                        break;
                    case "price":
                        book.setPrice(reader.getElementText());
                        break;
                    default:
                        break;
                }
            }
            if (event.isEndElement() && "book".equalsIgnoreCase(event.asEndElement().getName().getLocalPart())) {
                bookList.add(book);
            }
        }
        reader.close();
        bookList.stream().forEach(System.out::println);
    }

    // Cursor Api
    private static void demo02() throws FileNotFoundException, XMLStreamException {
        XMLStreamReader reader = getXmlStreamReader();
        List<Book> bookList = new ArrayList<>();

        int status;
        String localPart = "";
        for (Book book = null; reader.hasNext(); ) {
            status = reader.next();
            switch (status) {
                case XMLStreamConstants.START_ELEMENT:
                    localPart = reader.getName().getLocalPart();
                    book = startElementOperation(reader, localPart, book);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if ("book".equalsIgnoreCase(reader.getName().getLocalPart())) {
                        bookList.add(book);
                    }
                    break;
                default:
                    break;
            }
        }
        reader.close();
        bookList.stream().forEach(System.out::println);
    }

    // Cursor Api
    private static void demo01() throws XMLStreamException, FileNotFoundException {
        XMLStreamReader reader = getXmlStreamReader();

        List<Book> bookList = new ArrayList<>();
        String localPart;
        for (Book book = null; reader.hasNext(); ) {
            reader.next();
            if (reader.isStartElement()) {
                localPart = reader.getName().getLocalPart();
                book = startElementOperation(reader, localPart, book);
            }
            if (reader.isEndElement() && "book".equalsIgnoreCase(reader.getName().getLocalPart())) {
                bookList.add(book);
            }
        }
        reader.close();
        bookList.stream().forEach(System.out::println);
    }

    private static XMLEventReader getXmlEventReader() throws XMLStreamException, FileNotFoundException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        return factory.createXMLEventReader(new FileInputStream(DemoConstant.XML_PATH));
    }

    private static Book startElementOperation(XMLStreamReader reader, String localPart, Book book) throws XMLStreamException {
        switch (localPart) {
            case "book":
                book = new Book();
                book.setYear(Integer.parseInt(reader.getAttributeValue(0)));
                break;
            case "title":
                book.setTitle(reader.getElementText());
                break;
            case "author":
                book.setAuthor(reader.getElementText());
                break;
            case "publisher":
                book.setPublisher(reader.getElementText());
                break;
            case "isbn":
                book.setIsbn(reader.getElementText());
                break;
            case "price":
                book.setPrice(reader.getElementText());
                break;
            default:
                break;

        }
        return book;
    }


    private static XMLStreamReader getXmlStreamReader() throws XMLStreamException, FileNotFoundException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        return factory.createXMLStreamReader(new FileInputStream(DemoConstant.XML_PATH));
    }
}
