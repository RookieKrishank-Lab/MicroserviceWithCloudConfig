package com.service.employee.service.impl;

import com.service.employee.dto.APIResponse;
import com.service.employee.dto.DepartmentDto;
import com.service.employee.dto.EmployeeDto;
import com.service.employee.dto.OrganizationDto;
import com.service.employee.entity.Employee;
import com.service.employee.mapper.EmployeeMapper;
import com.service.employee.repository.EmployeeRepository;
import com.service.employee.service.APIClient;
import com.service.employee.service.EmployeeService;
import com.service.employee.service.OrganizationService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    private APIClient apiClient;

    private OrganizationService organizationService;

//    private WebClient webClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){

        Employee employee = EmployeeMapper.getEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.getEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponse getEmployeeId(Long employeeId) {

        LOGGER.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = apiClient.getByDepartmentCode(employee.getDepartmentCode());

        OrganizationDto organizationDto = organizationService.getOrganization(employee.getOrganizationCode());

        /*DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/v1/department/departCode/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8082/api/v1/organizations/getOrganization/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();*/

        EmployeeDto employeeDto = EmployeeMapper.getEmployeeDto(employee);

        APIResponse apiResponse = new APIResponse();
        apiResponse.setEmployeeDto(employeeDto);
        apiResponse.setDepartmentDto(departmentDto);
        apiResponse.setOrganizationDto(organizationDto);
        return apiResponse;
    }

    public APIResponse getDefaultDepartment(Long employeeId, Exception exception){

        LOGGER.info("inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("Default name");
        departmentDto.setDepartmentCode("1XX1");
        departmentDto.setDepartmentDescription("Default message");

        EmployeeDto employeeDto = EmployeeMapper.getEmployeeDto(employee);

        APIResponse apiResponse = new APIResponse();
        apiResponse.setEmployeeDto(employeeDto);
        apiResponse.setDepartmentDto(departmentDto);
        return apiResponse;
    }

}
