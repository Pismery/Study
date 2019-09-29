package com.pismery.study.api.excel.jxls;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class JXLSUtilTest {

    @Test
    public void generateExcel_grouping() throws IOException {
        //Given
        List<Employee> staff = Arrays.asList(
                buildEmployee("IQ Chan1", new Date(), new BigDecimal(10000.01), new BigDecimal(0.15)),
                buildEmployee("IQ Chan1", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25)),
                buildEmployee("IQ Chan2", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25)),
                buildEmployee("IQ Chan2", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25)),
                buildEmployee("IQ Chan2", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25)),
                buildEmployee("Pismery1", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25)),
                buildEmployee("Pismery1", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25))
        );
        Map<String, Object> model = new HashMap<>();
        model.put("employees", staff);
        //When
        JXLSUtil.generateExcel(model,"grouping_template.xlsx","grouping_report.xlsx");
        //Then
    }

    @Test
    public void generateExcel_muti_sheet() throws IOException {
        //Given
        List<Employee> hrStaff = getStaffList("IQ Chan1", "IQ Chan2");
        List<Employee> itStaff = getStaffList("Pismery1", "Pismery2");
        Employee hr_chief = buildEmployee("HR Chief", new Date(), new BigDecimal(30000.05), new BigDecimal(0.5));
        Employee it_chief = buildEmployee("IT Chief", new Date(), new BigDecimal(30000.05), new BigDecimal(0.5));
        List<Department> departmentList = Arrays.asList(
                buildDepartment("HR", hr_chief, "HR Link", hrStaff),
                buildDepartment("IT", it_chief, "IT Link", itStaff)
        );
        Map<String, Object> model = new HashMap<>();
        model.put("departments", departmentList);
        model.put("employees", hrStaff);
        model.put("sheetNames", Arrays.asList(departmentList.get(0).getName(), departmentList.get(1).getName()));
        //When
        JXLSUtil.generateMultiSheetExcel(model, "multi_sheet_template.xlsx","multi_sheet_report.xlsx");
        //Then
    }

    @Test
    public void generateExcel_each_if_command() throws IOException {
        //Given
        List<Employee> hrStaff = getStaffList("IQ Chan1", "IQ Chan2");
        List<Employee> itStaff = getStaffList("Pismery1", "Pismery2");
        Employee hr_chief = buildEmployee("HR Chief", new Date(), new BigDecimal(30000.05), new BigDecimal(0.5));
        Employee it_chief = buildEmployee("IT Chief", new Date(), new BigDecimal(30000.05), new BigDecimal(0.5));
        List<Department> departmentList = Arrays.asList(
                buildDepartment("HR", hr_chief, "HR Link", hrStaff),
                buildDepartment("IT", it_chief, "IT Link", itStaff)
        );
        Map<String, Object> model = new HashMap<>();
        model.put("departments", departmentList);
        model.put("employees", hrStaff);
        //When
        JXLSUtil.generateExcel(model, "each_if_demo_template.xlsx","each_if_demo_report.xlsx");
        //Then
    }

    @Test
    public void generateExcel_formulas() throws IOException {
        //Given
        List<Employee> staff = Arrays.asList(
                buildEmployee("IQ Chan1", new Date(), new BigDecimal(10000.01), new BigDecimal(0.15)),
                buildEmployee("IQ Chan2", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25))
        );
        Map<String, Object> model = new HashMap<>();
        model.put("employees", staff);
        //When
        JXLSUtil.generateExcel(model,"excel_formulas_template.xlsx","excel_formulas_report.xlsx");
        //Then
    }

    @Test
    public void generateExcel_object_collection() throws IOException {
        //Given
        List<Employee> staff = Arrays.asList(
                buildEmployee("IQ Chan1", new Date(), new BigDecimal(10000.01), new BigDecimal(0.15)),
                buildEmployee("IQ Chan2", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25))
        );
        Map<String, Object> model = new HashMap<>();
        model.put("employees", staff);
        //When
        JXLSUtil.generateExcel(model, "object_collection_template.xlsx", "object_collection_report.xlsx");
        //Then
    }

    @Test
    public void generateTableExcel() throws IOException {
        //Given
        List<Employee> staff = Arrays.asList(
                buildEmployee("IQ Chan1", new Date(), new BigDecimal(10000.01), new BigDecimal(0.15)),
                buildEmployee("IQ Chan2", new Date(), new BigDecimal(20000.05), new BigDecimal(0.25))
        );
        //When
        JXLSUtil.generateTableExcel(staff);
        //Then
    }

    @NotNull
    private List<Employee> getStaffList(String staff1, String staff2) {
        return Arrays.asList(
                buildEmployee(staff1, new Date(), new BigDecimal(10000.01), new BigDecimal(0.15)),
                buildEmployee(staff2, new Date(), new BigDecimal(20000.05), new BigDecimal(0.25))
        );
    }


    private static Employee buildEmployee(String name, Date birthdate, BigDecimal payment, BigDecimal bonus) {
        return Employee.builder()
                .name(name)
                .birthDate(birthdate)
                .years(1)
                .payment(payment)
                .bonus(bonus)
                .build();
    }

    private static Department buildDepartment(String name, Employee chief, String link, List<Employee> staff) {
        return Department.builder()
                .name(name)
                .chief(chief)
                .link(link)
                .staff(staff)
                .build();
    }
}