package com.pismery.study.api.stream;

import lombok.Data;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Data
@ToString
public class Person implements Comparable {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return this.getId() > ((Person) o).getId() ? 1 : -1;
    }
}
