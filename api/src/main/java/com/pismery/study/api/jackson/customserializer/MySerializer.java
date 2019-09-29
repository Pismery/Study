package com.pismery.study.api.jackson.customserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MySerializer extends StdSerializer<Writer> {
    public MySerializer() {
        super(Writer.class);
    }

    @Override
    public void serialize(Writer writer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("WriterName", writer.getName());

        jsonGenerator.writeObjectFieldStart("Custom-Address");
        jsonGenerator.writeStringField("Custom-Country", writer.getAddress().getCountry());
        jsonGenerator.writeStringField("Custom-City", writer.getAddress().getCity());
        jsonGenerator.writeEndObject();

        jsonGenerator.writeArrayFieldStart("Custom-BookList");
        writer.getBookList().stream()
                .forEach(book -> {
                    try {
                        jsonGenerator.writeStartObject();
                        jsonGenerator.writeStringField("Custom-BookName", book.getName());
                        jsonGenerator.writeStringField("Custom-BookCateory", book.getCategory());
                        jsonGenerator.writeEndObject();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        jsonGenerator.writeEndArray();

        jsonGenerator.writeObjectFieldStart("Custom-FavBook");
        writer.getFavoriteBook().forEach((key, value) -> {
            try {
                jsonGenerator.writeObjectFieldStart("Custom-"+key);
                jsonGenerator.writeStringField("Custom-BookName", value.getName());
                jsonGenerator.writeStringField("Custom-BookCateory", value.getCategory());
                jsonGenerator.writeEndObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        jsonGenerator.writeEndObject();
    }
}
