package com.pismery.study.mapsturct.demo01;

import java.util.Date;

/**
 * @author 盒子
 * @since 2022/1/24
 */
public class Main {
    public static void main(String[] args) {
        StudentDO studentDO = StudentDO.builder()
                .id("213").firstName("Liu").lastName("Pismery")
                .gender(Gender.MALE)
                .birthday(new Date())
                .age(123).build();

        System.out.println(studentDO);
        StudentDTO studentDTO = StudentMapper.INSTANCE.toStudentDTO(
                studentDO
        );
        System.out.println(studentDTO);

        System.out.println(StudentMapper.INSTANCE.toStudentDO(studentDTO));
    }
}
