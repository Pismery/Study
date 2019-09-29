package com.pismery.study.api.jackson.customserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @JsonProperty("name")
    private String name;
    @JsonProperty("category")
    private String category;
}
