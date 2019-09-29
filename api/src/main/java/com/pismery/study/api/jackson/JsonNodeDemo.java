package com.pismery.study.api.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonNodeDemo {

    public static void main(String[] args) throws IOException {
        String json = "{\n" +
                "  \"id\":1,\n" +
                "  \"name\":\"Arvind\",\n" +
                "  \"village\":\"Dhananjaypur\",\n" +
                "  \"district\":\"Varanasi\",\n" +
                "  \"state\":\"UP\"\n" +
                "} ";

        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.setCodec(new ObjectMapper());
        JsonNode node = parser.readValueAsTree();
        node.forEach(n-> System.out.println(n.asText()));
    }
}
