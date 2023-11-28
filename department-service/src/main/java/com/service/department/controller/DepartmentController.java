package com.service.department.controller;

import com.service.department.dto.DepartmentDto;
import com.service.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Controller Service",
        description = "Using the following request user can Add Department and Fetch Department by ID"
)

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation(
            summary = "Add new department",
            description = "Using this you can add new dept."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    @Operation(
            summary = "Find department by there dept code",
            description = "Using this you can find particular dept."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/departCode/{departmentCode}")
    public ResponseEntity<DepartmentDto> getByDepartmentCode(@PathVariable String departmentCode){
        DepartmentDto departmentByCode = departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.status(HttpStatus.OK).body(departmentByCode);
    }

}
