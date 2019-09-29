package com.pismery.study.api.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonIncludeDemo {
    @JsonInclude()
    private String propertyA;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String propertyB;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String propertyC;

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    private String propertyD;
    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    private int propertyE;

    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private Optional<String> optional;

    public static void main(String[] args) throws IOException {
        JsonIncludeDemo demo = new JsonIncludeDemo("pA", null, "", "",0,Optional.empty());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SimpleModule());
        System.out.println("Object to Json: " + mapper.writeValueAsString(demo));

        String json = "{\"propertyA\":\"pA\"}";
        System.out.println("Json to Obejct: " + mapper.readValue(json, JsonIncludeDemo.class));
    }
}

