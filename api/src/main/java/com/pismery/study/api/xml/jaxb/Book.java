package com.pismery.study.api.xml.jaxb;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@XmlRootElement(name="book")
@XmlAccessorType(XmlAccessType.NONE)
public class Book {
    @XmlAttribute(name="year")
    private int year;
    @XmlElement(name="title")
    private String title;
    @XmlElement(name="author")
    private String author;
    @XmlElement(name="publisher")
    private String publisher;
    @XmlElement(name="isbn")
    private String isbn;
    @XmlElement(name="price")
    private String price;
}
