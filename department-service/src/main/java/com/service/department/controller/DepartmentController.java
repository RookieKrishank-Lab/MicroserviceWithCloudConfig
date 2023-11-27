package com.service.department.controller;

import com.service.department.dto.DepartmentDto;
import com.service.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    @GetMapping("/departCode/{departmentCode}")
    public ResponseEntity<DepartmentDto> getByDepartmentCode(@PathVariable String departmentCode){
        DepartmentDto departmentByCode = departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.status(HttpStatus.OK).body(departmentByCode);
    }

}
