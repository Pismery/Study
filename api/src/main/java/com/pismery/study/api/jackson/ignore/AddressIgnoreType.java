package com.pismery.study.api.jackson.ignore;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;



@JsonIgnoreType
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressIgnoreType {
    @JsonProperty
    private String country;
    @JsonProperty
    private String city;

    public static void main(String[] args) throws IOException {
        AddressIgnoreType address = new AddressIgnoreType("China", "GZ");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Object to Json: " + mapper.writeValueAsString(address));

        String addressJson = "{\"country\":\"China\",\"city\":\"GZ\"}";
        System.out.println("Json to Object: "+mapper.readValue(addressJson, AddressIgnoreType.class));

    }
}
