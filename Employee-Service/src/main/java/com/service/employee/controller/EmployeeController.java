package com.service.employee.controller;

import com.service.employee.dto.APIResponse;
import com.service.employee.dto.EmployeeDto;
import com.service.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Controller Service",
        description = "Using the following request user can Add Employee and Fetch Employee by ID"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(
            summary = "Add new employee",
            description = "Using this you can add new employee."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @Operation(
            summary = "Find employee details by ID",
            description = "Using this you can find particular employee details."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/getEmployeeById/{employeeId}")
    public ResponseEntity<APIResponse> getByEmployeeId(@PathVariable Long employeeId){
        APIResponse employee = employeeService.getEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
}
