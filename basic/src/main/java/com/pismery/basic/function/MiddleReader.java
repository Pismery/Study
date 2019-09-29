package com.pismery.basic.function;

import java.util.List;

public class MiddleReader {
    private CellReader cellReader;
    private String fieldName;
    private Object defaultValue;

    public MiddleReader(CellReader cellReader, String fieldName, Object defaultValue) {
        this.cellReader = cellReader;
        this.fieldName = fieldName;
        this.defaultValue = defaultValue;
    }

    public Object read(List<String> errorList) {
        return cellReader.read(fieldName, defaultValue, errorList);
    }


}
