package com.pismery.study.api.excel.jxls;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private String name;
    private Employee chief;
    private List<Employee> staff = new ArrayList<>();
    private String link;
}
