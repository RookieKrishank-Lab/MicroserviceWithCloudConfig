package com.service.employee.mapper;

import com.service.employee.dto.EmployeeDto;
import com.service.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto getEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        return  employeeDto;
    }

    public static Employee getEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        return employee;
    }
}
