package com.pismery.study.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderUtilsTest {

    private List<Employee> multipleList;
    private List<Employee> singleList;

    @Before
    public void init() {
        multipleList = Arrays.asList(
                new Employee(1, "A", 30, Position.BRAND_1),
                new Employee(2, "A", 30, Position.BRAND_3),
                new Employee(3, "A", 30, Position.BRAND_2),
                new Employee(4, "A", 32, Position.BRAND_1),
                new Employee(5, "A", 32, Position.BRAND_3),
                new Employee(6, "A", 32, Position.BRAND_2),
                new Employee(7, "A", 31, Position.BRAND_1),
                new Employee(8, "A", 31, Position.BRAND_3),
                new Employee(9, "A", 31, Position.BRAND_2),

                new Employee(10, "C", 30, Position.BRAND_1),
                new Employee(11, "B", 30, Position.BRAND_1),
                new Employee(12, "D", 30, Position.BRAND_1)
        );

        singleList = Arrays.asList(
                new Employee(1, "A", 34, Position.BRAND_1),
                new Employee(4, "C", 30, Position.BRAND_3),
                new Employee(3, "D", 31, Position.BRAND_2),
                new Employee(2, "B", 25, Position.BRAND_4)
        );
    }


    @Test
    public void orderBy_multiple_java8_asc() {
        //Given
        System.out.println("orderBy_multiple_java8_asc");
        //When
        OrderUtils.orderBy(multipleList
                , Comparator.comparing(Employee::getName)
                , Comparator.comparing(Employee::getAge)
                , Comparator.comparing(Employee::getPosition)
        );

        multipleList.forEach(System.out::println);
    }


    @Test
    public void orderBy_multiple_java7_asc() {
        //Given
        System.out.println("orderBy_multiple_java8_asc");
        //When
        Collections.sort(multipleList, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        int result;
                        result = o1.getName().compareTo(o2.getName());
                        if (result != 0) {
                            return result;
                        }

                        result = o1.getAge().compareTo(o2.getAge());
                        if (result != 0) {
                            return result;
                        }

                        return o1.getPosition().compareTo(o2.getPosition());
                    }
                }
        );

        multipleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_multiple_java8_desc() {
        //Given
        System.out.println("orderBy_multiple_java8_desc");
        //When
        OrderUtils.orderBy(multipleList
                , Comparator.comparing(Employee::getName)
                , Comparator.comparing(Employee::getAge)
                , Comparator.comparing(Employee::getPosition).reversed()
        );

        multipleList.forEach(System.out::println);
    }


    @Test
    public void orderBy_multiple_java7_desc() {
        //Given
        System.out.println("orderBy_multiple_java8_desc");
        //When
        Collections.sort(multipleList, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        int result;
                        result = o1.getName().compareTo(o2.getName());
                        if (result != 0) {
                            return result;
                        }

                        result = o1.getAge().compareTo(o2.getAge());
                        if (result != 0) {
                            return result;
                        }

                        return o2.getPosition().compareTo(o1.getPosition());
                    }
                }
        );

        multipleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_multiple_java8_customer() {
        //Given
        System.out.println("orderBy_multiple_java8_customer");
        //When

        OrderUtils.orderBy(multipleList
                , Comparator.comparing(Employee::getName)
                , Comparator.comparing(Employee::getAge)
                , (o1, o2) -> {
                    Integer o1Weight = customerPositionWeight(o1);
                    Integer o2Weight = customerPositionWeight(o2);

                    return o1Weight.compareTo(o2Weight);
                }
        );

        //Then
        multipleList.forEach(System.out::println);
    }


    @Test
    public void orderBy_multiple_java7_customer() {
        //Given
        System.out.println("orderBy_multiple_java7_customer");
        //When
        Collections.sort(multipleList, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        int result;
                        result = o1.getName().compareTo(o2.getName());
                        if (result != 0) {
                            return result;
                        }

                        result = o1.getAge().compareTo(o2.getAge());
                        if (result != 0) {
                            return result;
                        }

                        Integer o1Weight = customerPositionWeight(o1);
                        Integer o2Weight = customerPositionWeight(o2);
                        return o1Weight.compareTo(o2Weight);
                    }
                }
        );

        multipleList.forEach(System.out::println);
    }


    private static Integer customerPositionWeight(Employee employee) {
        switch (employee.getPosition()) {
            case BRAND_1:
                return 2;
            case BRAND_2:
                return 1;
            case BRAND_3:
                return 4;
            case BRAND_4:
                return 3;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Test
    public void orderBy_single_string_java8_asc() {
        //Given
        System.out.println("orderBy_single_string_java8_asc");
        //When
        singleList.sort(Comparator.comparing(Employee::getName));

        singleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_single_string_comparable_asc() {
        //Given
        System.out.println("orderBy_single_string_comparable_asc");
        //When

        Collections.sort(singleList);

        singleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_single_string_java7_asc() {
        //Given
        System.out.println("orderBy_single_string_java7_asc");
        //When

        Collections.sort(singleList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        singleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_single_string_java8_desc() {
        //Given
        System.out.println("orderBy_single_string_java8_desc");
        //When
        singleList.sort(Comparator.comparing(Employee::getName).reversed());

        singleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_single_string_java7_desc() {
        //Given
        System.out.println("orderBy_single_string_java7_desc");
        //When
        Collections.sort(singleList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });

        singleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_single_enum_java8_asc() {
        //Given
        System.out.println("orderBy_single_enum_java8_asc");
        //When
        singleList.sort(Comparator.comparing(Employee::getPosition));

        singleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_single_enum_java7_asc() {
        //Given
        System.out.println("orderBy_single_enum_java7_asc");
        //When
        Collections.sort(singleList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getPosition().compareTo(o2.getPosition());
            }
        });

        singleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_single_enum_java8_desc() {
        //Given
        System.out.println("orderBy_single_enum_java8_desc");
        //When
        singleList.sort(Comparator.comparing(Employee::getPosition).reversed());

        singleList.forEach(System.out::println);
    }

    @Test
    public void orderBy_single_enum_java7_desc() {
        //Given
        System.out.println("orderBy_single_enum_java7_desc");
        //When
        Collections.sort(singleList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getPosition().compareTo(o1.getPosition());
            }
        });

        singleList.forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    private static class Employee implements Comparable<Employee>{
        private Integer id;
        private String name;
        private Integer age;
        private Position position;

        @Override
        public int compareTo(Employee employee) {
            return this.name.compareTo(employee.getName());
            //return employee.getName().compareTo(this.name);
        }
    }

    private enum Position {
        BRAND_1, BRAND_2, BRAND_3, BRAND_4
    }
}