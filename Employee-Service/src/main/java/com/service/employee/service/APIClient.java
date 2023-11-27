package com.service.employee.service;

import com.service.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")                                            // FeignClient library will dynamically create an implementation for this interface
public interface APIClient {
    @GetMapping("/api/v1/department/departCode/{departmentCode}")
    DepartmentDto getByDepartmentCode(@PathVariable("departmentCode") String departmentCode);
    //    http://localhost:8080/api/v1/department/departCode/CS101

//    @GetMapping("/departCode/{departmentCode}")
//    public ResponseEntity<DepartmentDto> getByDepartmentCode(@PathVariable String departmentCode){
//
}
