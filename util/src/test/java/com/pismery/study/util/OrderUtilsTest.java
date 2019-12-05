package com.pismery.study.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrderUtilsTest {
    
    @Test
    public void orderBy_multiple_field() {
        //Given
        List<Employee> list = Arrays.asList(new Employee(1, "A", "B", 34),
                new Employee(4, "C", "D", 30),
                new Employee(3, "B", "A", 31),
                new Employee(2, "D", "C", 25));
        //When
        OrderUtils.orderBy(list
                , Comparator.comparing(Employee::getFirstName)
                , Comparator.comparing(Employee::getLastName)
                , Comparator.comparing(Employee::getAge)
        );
        
        System.out.println(list);
    }
    
    @Test
    public void orderBy_single_field() {
        //Given
        List<Employee> list = Arrays.asList(new Employee(1, "A", "B", 34),
                new Employee(4, "C", "D", 30),
                new Employee(3, "B", "A", 31),
                new Employee(2, "D", "C", 25));
        //When
        OrderUtils.orderBy(list, Comparator.comparing(Employee::getAge));
        
        System.out.println(list);
    }
    
    @Data
    @AllArgsConstructor
    private static class Employee {
        private Integer id = -1;
        private String firstName = null;
        private String lastName = null;
        private Integer age = -1;
    }
}