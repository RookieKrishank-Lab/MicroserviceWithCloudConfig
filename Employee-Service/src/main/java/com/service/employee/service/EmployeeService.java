package com.service.employee.service;

import com.service.employee.dto.APIResponse;
import com.service.employee.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponse getEmployeeId(Long employeeId);
}
