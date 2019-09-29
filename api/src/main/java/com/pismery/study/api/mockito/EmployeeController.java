package com.pismery.study.api.mockito;

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void holdLife(Employee employee) {
        System.out.println("saveEmployee: "+employeeService.saveEmployee(employee));
        System.out.println("getEmployeeSum: "+employeeService.getEmployeeSum(employee));
        System.out.println("updateEmployee: "+employeeService.updateEmployee(employee));
        System.out.println("deleteEmployee: "+employeeService.deleteEmployee(employee));
        System.out.println("getEmployeeName: "+employeeService.getEmployeeName());
    }
}
