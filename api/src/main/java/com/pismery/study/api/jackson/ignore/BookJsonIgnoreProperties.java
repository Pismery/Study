package com.pismery.study.api.jackson.ignore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"category"},allowGetters = true,allowSetters = true,ignoreUnknown = true)
public class BookJsonIgnoreProperties {
    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    public static void main(String[] args) throws IOException {
        BookJsonIgnoreProperties book = new BookJsonIgnoreProperties("myBook","computer");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Object to Json: " + mapper.writeValueAsString(book));

        String bookJson = "{\"name\":\"Bookname\",\"category\":\"computer\"}";
        System.out.println("Json to Object: "+mapper.readValue(bookJson, BookJsonIgnoreProperties.class));
    }
}
