package com.pismery.study.api.jackson;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonAliasDemo {

    @JsonAlias({"aliasA","aliasB"})
    @JsonProperty("customer-property")
    private String propertyA;

    public static void main(String[] args) throws IOException {
        JsonAliasDemo demo = new JsonAliasDemo("pA");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Object to Json: " + mapper.writeValueAsString(demo));

        String json;
        json = "{\"customer-property\":\"pA\"}";
        System.out.println("Json to Object: " + mapper.readValue(json, JsonAliasDemo.class));
        json = "{\"aliasA\":\"pA\"}";
        System.out.println("Json to Object: " + mapper.readValue(json, JsonAliasDemo.class));
        json = "{\"aliasB\":\"pA\"}";
        System.out.println("Json to Object: " + mapper.readValue(json, JsonAliasDemo.class));
    }
}
