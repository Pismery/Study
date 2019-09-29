package com.pismery.study.api.xml.jaxb;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name="inventory")
@XmlAccessorType(XmlAccessType.NONE)
public class Inventory {
    @XmlElement(name = "book")
    private List<Book> bookList;
}
