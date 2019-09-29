package com.pismery.study.gof23.pattern.create.prototype.java;

import com.pismery.study.gof23.pattern.create.prototype.Address;
import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer age;
    private Address address;

    public Person() {
    }

    public Person(Person person) {
        this.name = new String(person.getName());
        this.address = new Address(person.getAddress().getCountry(), person.getAddress().getProvince());
        this.age = person.getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
