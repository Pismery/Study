package com.pismery.study.api.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class AnyGetterSetterDemo {
    @JsonAnySetter
    private Map<String, String> map = new HashMap<>();

    @JsonProperty("village")
    private String name;

    @JsonAnyGetter
    private Map<String, String> getMap() {
        return this.map;
    }


    private void setMap(String key, String value) {
        this.map.put(key, value);
    }


    public static void main(String[] args) throws IOException {
        AnyGetterSetterDemo demo = new AnyGetterSetterDemo();
        Map<String, String> mapDetials = demo.getMap();

        mapDetials.put("village", "ABCD");
        mapDetials.put("district", "Varanasi");
        mapDetials.put("state", "Uttar Pradesh");
        mapDetials.put("country", "India");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Object to Json: " + mapper.writeValueAsString(demo));

        String jsonStr = "{\"country\":\"India\",\"district\":\"Varanasi\",\"state\":\"Uttar Pradesh\",\"village\":\"ABCD\"}";
        System.out.println("Json to Object: " + mapper.readValue(jsonStr, AnyGetterSetterDemo.class));
    }
}
