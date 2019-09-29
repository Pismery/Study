package com.pismery.study.api.xml.sax;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {
    private int year;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String price;
}
