package com.service.employee.controller;

import com.service.employee.dto.ApiResponse;
import com.service.employee.dto.EmployeeDto;
import com.service.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public ResponseEntity<ApiResponse> getByEmployeeId(@PathVariable Long employeeId){
        ApiResponse employee = employeeService.getEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
}
