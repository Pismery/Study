package com.pismery.study.api.excel.jxls;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private Integer years;
    private Date birthDate;
    private BigDecimal payment;
    private BigDecimal bonus;
}
