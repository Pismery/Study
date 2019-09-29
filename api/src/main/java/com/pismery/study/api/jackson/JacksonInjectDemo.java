package com.pismery.study.api.jackson;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class JacksonInjectDemo {

    @JacksonInject
    private String propertyA;

    @JacksonInject("propertyB")
    private String propertyB;

    @JacksonInject("propertyC")
    private String propertyC;



    public static void main(String[] args) throws IOException {
        JacksonInjectDemo demo = new JacksonInjectDemo("pA", "pB","pc");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Object to Json: " + mapper.writeValueAsString(demo));


        InjectableValues values = new InjectableValues.Std()
                .addValue(String.class,"pA-Inject")
                .addValue("propertyB","pB-Inject")
                .addValue("propertyC","pC-Inject");
        mapper.setInjectableValues(values);
        String jsonStr = "{\"propertyA\":\"pA\",\"propertyB\":\"pB\"}";
        System.out.println("Json to Object: " + mapper.readValue(jsonStr, JacksonInjectDemo.class));
    }
}
