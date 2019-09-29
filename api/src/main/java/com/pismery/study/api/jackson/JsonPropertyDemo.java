package com.pismery.study.api.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonPropertyDemo {
    @JsonProperty(value = "customer-propertyA", required = true)
    private String propertyA;


    public static void main(String[] args) throws IOException {
        JsonPropertyDemo demo = new JsonPropertyDemo("pA");

        ObjectMapper mapper = new ObjectMapper();

        System.out.println("Object to Json: " + mapper.writeValueAsString(demo));

        String json = " {\"customer-propertyA\":\"pA\"}";
        System.out.println("Json to Object: " + mapper.readValue(json, JsonPropertyDemo.class));

    }
}
