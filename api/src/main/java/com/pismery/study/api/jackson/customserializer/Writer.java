package com.pismery.study.api.jackson.customserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = MySerializer.class)
public class Writer {
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private Address address;

    @JsonProperty("bookList")
    private List<Book> bookList;
    @JsonProperty("favBook")
    private Map<String ,Book> favoriteBook;
}
