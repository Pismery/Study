package com.pismery.study.api.mockito;

public class EmployeeService {
    public EmployeeService() {

    }

    private String getEmployeeCount(Employee employee) {
        throw new UnsupportedOperationException();
    }

    public static String updateEmployee(Employee employee) {
        return "";
    }

    public final String saveEmployee(Employee employee) {
        return "";
    }

    public static final String deleteEmployee(Employee employee) {
        return "";
    }

    public String getEmployeeSum(Employee employee) {
        return getEmployeeCount(employee);
    }

    public String getEmployeeName() {
        Employee employee = new Employee();
        return employee.getfName();
    }
}
