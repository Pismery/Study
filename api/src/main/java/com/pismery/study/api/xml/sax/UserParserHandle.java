package com.pismery.study.api.xml.sax;

import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Slf4j
public class UserParserHandle extends DefaultHandler {
    private List<Book> bookList = new ArrayList<>();
    private Stack<Book> bookStack = new Stack();
    private Stack<String> elementStack = new Stack();

    private String currentElement() {
        return elementStack.peek();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    /**
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        if ("book".equalsIgnoreCase(qName)) {
            Book book= new Book();
            if (attributes != null && attributes.getLength() == 1) {
                book.setYear(Integer.parseInt(attributes.getValue("year")));
            }
            bookStack.push(book);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (length == 0)
            return;

        String value = new String(ch,start,length).trim();

        switch (currentElement()) {
            case "title":
                bookStack.peek().setTitle(value);
                break;
            case "author":
                bookStack.peek().setAuthor(value);
                break;
            case "publisher":
                bookStack.peek().setPublisher(value);
                break;
            case "isbn":
                bookStack.peek().setIsbn(value);
                break;
            case "price":
                bookStack.peek().setPrice(value);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        if ("book".equalsIgnoreCase(qName)) {
            bookList.add(bookStack.pop());
        }
    }

    @Override
    public void startDocument() throws SAXException {
        log.debug("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        this.getBookList().stream().forEach(book -> log.debug(book.toString()));
        log.debug("endDocument");
    }
}
