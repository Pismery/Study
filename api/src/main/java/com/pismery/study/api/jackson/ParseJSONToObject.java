package com.pismery.study.api.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ParseJSONToObject {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonInput = "{\"id\":0,\"firstName\":\"Robin\",\"lastName\":\"Wilson\"}";
        Person q = mapper.readValue(jsonInput, Person.class);
        System.out.println("Read and parsed Person from JSON: " + q);

        jsonInput = mapper.writeValueAsString(q);
        System.out.println("Read and parsed JSON from Person " + jsonInput);
    }
}
