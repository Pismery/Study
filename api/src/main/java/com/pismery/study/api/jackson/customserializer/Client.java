package com.pismery.study.api.jackson.customserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

    public static void main(String[] args) throws JsonProcessingException {
        Writer writer = initWriter();
        annoationSerializer(writer);
        customSerializer(writer);
    }

    private static void annoationSerializer(Writer writer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Default Serializer: "+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(writer));
    }

    private static void customSerializer(Writer writer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =new SimpleModule();
        module.addSerializer(new MySerializer());
        mapper.registerModule(module);
        System.out.println("Custom Serializer: "+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(writer));
    }

    @NotNull
    private static Writer initWriter() {
        Address address = new Address("Noida", "India");
        Book book1 = new Book("Learning Java", "Java");
        Book book2 = new Book("Learning Hibernate", "Hibernate");
        Book book3 = new Book("Learning Spring", "Spring");
        List<Book> allBookList = Arrays.asList(book1, book2, book3);
        Map<String, Book> favBookMap = new HashMap<>();
        favBookMap.put("A101", book1);
        favBookMap.put("B202", book2);
        return new Writer("Mohit", address, allBookList, favBookMap);
    }


}
