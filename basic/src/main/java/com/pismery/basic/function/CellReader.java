package com.pismery.basic.function;

import java.util.List;

@FunctionalInterface
public interface CellReader {

    Object doRead(String field);

    default Object read(String field,Object defaultValue, List<String> errorList) {
        try {
            return doRead(field);
        } catch (Exception e) {
            errorList.add(field);
            return defaultValue;
        }
    }


}
