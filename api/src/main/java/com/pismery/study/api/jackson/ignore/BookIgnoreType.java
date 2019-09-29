package com.pismery.study.api.jackson.ignore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookIgnoreType {
    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    @JsonProperty("address")
    private AddressIgnoreType address;

    public static void main(String[] args) throws IOException {
        BookIgnoreType book = new BookIgnoreType("bookName", "computer", new AddressIgnoreType("China", "GZ"));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Object to Json: "+mapper.writeValueAsString(book));

        String bookJson = "{\"name\":\"bookName\",\"category\":\"computer\",\"address\":{\"country\":\"China\",\"city\":\"GZ\"}}";
        System.out.println("Json to Object: "+mapper.readValue(bookJson, BookIgnoreType.class));

    }
}
