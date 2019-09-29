package com.pismery.study.api.jackson.ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookJsonIgnore {
    @JsonProperty("name")
    private String name;


    @JsonIgnore()
    @JsonProperty("category2")
    private String category;

    @JsonIgnore()
    public String getCategory() {
        return category;
    }
    @JsonIgnore()
    public void setCategory(String category) {
        this.category = category;
    }

    public static void main(String[] args) throws IOException {
        BookJsonIgnore book = new BookJsonIgnore("Bookname", "computer");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Object to Json: "+mapper.writeValueAsString(book));

        String bookJson = "{\"name\":\"Bookname\",\"category2\":\"computer\"}";
        System.out.println("Json to Object: "+mapper.readValue(bookJson, BookJsonIgnore.class));
    }
}
