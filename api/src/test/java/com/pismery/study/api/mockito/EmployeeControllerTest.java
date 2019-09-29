package com.pismery.study.api.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
public class EmployeeControllerTest {

    @Test
    @PrepareForTest(EmployeeService.class)
    public void holdLife() throws Exception {
        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class, Mockito
                .withSettings()
                .name("Mock_EmployeeService")
        );
        PowerMockito.mockStatic(EmployeeService.class);
        EmployeeController employeeController = new EmployeeController(employeeService);
        Employee employee = new Employee();
        employee.setfName("mock name");

        //mock private 方法
        when(employeeService.getEmployeeSum(employee)).thenCallRealMethod();
        when(employeeService, "getEmployeeCount",any()).thenReturn("mock get employee count");

        //mock new 方法
        when(employeeService.getEmployeeName()).thenCallRealMethod();
        whenNew(Employee.class).withNoArguments().thenReturn(employee);
        //mock final 方法
        when(employeeService.saveEmployee(employee)).thenReturn("mock save employee");
        //mock static 方法
        when(EmployeeService.updateEmployee(employee)).thenReturn("mock update employee");
        //mock static final 方法
        when(EmployeeService.deleteEmployee(employee)).thenReturn("mock delete employee");

        employeeController.holdLife(employee);

        Mockito.verify(employeeService).saveEmployee(employee);
    }
}