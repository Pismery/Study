package com.pismery.study.mapsturct.demo01;

import lombok.*;

import java.util.Date;

/**
 * @author 盒子
 * @since 2022/1/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentDO {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private Date birthday;
    private Date createDate;
}