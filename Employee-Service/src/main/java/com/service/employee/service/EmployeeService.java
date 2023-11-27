package com.service.employee.service;

import com.service.employee.dto.ApiResponse;
import com.service.employee.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponse getEmployeeId(Long employeeId);
}
