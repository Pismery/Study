package com.pismery.study.mapsturct.demo01;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 盒子
 * @since 2022/1/24
 */
@Data
@Builder
@ToString
public class StudentDTO {
    private String id;
    private String name;
    private Integer studentAge;
    private String sex;
    private String birthday;
}
