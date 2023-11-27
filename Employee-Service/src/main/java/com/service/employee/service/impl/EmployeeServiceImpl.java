package com.service.employee.service.impl;

import com.service.employee.dto.ApiResponse;
import com.service.employee.dto.DepartmentDto;
import com.service.employee.dto.EmployeeDto;
import com.service.employee.entity.Employee;
import com.service.employee.mapper.EmployeeMapper;
import com.service.employee.repository.EmployeeRepository;
import com.service.employee.service.APIClient;
import com.service.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private APIClient apiClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){

        Employee employee = EmployeeMapper.getEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.getEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    public ApiResponse getEmployeeId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = apiClient.getByDepartmentCode(employee.getDepartmentCode());
        System.out.println(departmentDto);
        EmployeeDto employeeDto = EmployeeMapper.getEmployeeDto(employee);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setEmployeeDto(employeeDto);
        apiResponse.setDepartmentDto(departmentDto);
        return apiResponse;
    }

}
