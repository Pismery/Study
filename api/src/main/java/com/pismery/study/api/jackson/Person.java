package com.pismery.study.api.jackson;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
    private  Integer id;
    private  String firstName;
    private  String lastName;
}
