package com.pismery.basic.function;

import java.util.*;

public class ExcelReader {
    public static final String[] STRING_FIELDS = {"field2", "field1"};
    public static final String[] INTEGER_FEILDS = {"field3", "field4"};

    public static void main(String[] args) {
        Map<String, MiddleReader> map = new HashMap<>();

        Arrays.stream(STRING_FIELDS).forEach(field ->
                map.put(field, new MiddleReader(field2 -> "read Value", "fieldName", "defaultString"))
        );
        Arrays.stream(INTEGER_FEILDS).forEach(field ->
                map.put(field, new MiddleReader(field2 -> 1, "fieldName", 0))
        );
        Arrays.stream(INTEGER_FEILDS).forEach(field ->
                map.put(field, new MiddleReader(field2 -> {throw new RuntimeException();}, "fieldName", 0))
        );

        List<String> errorList = new ArrayList<>();
        System.out.println("field1 : "+map.get("field1").read(errorList));
        System.out.println("field3 : "+map.get("field3").read(errorList));

    }
}
