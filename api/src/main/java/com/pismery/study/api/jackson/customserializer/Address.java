package com.pismery.study.api.jackson.customserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
}
