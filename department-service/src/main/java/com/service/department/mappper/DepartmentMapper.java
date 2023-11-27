package com.service.department.mappper;

import com.service.department.dto.DepartmentDto;
import com.service.department.entity.Department;

public class DepartmentMapper {

    public Department getDepartment(DepartmentDto departmentDto){
    Department department = new Department(
            departmentDto.getDepartmentId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription(),
            departmentDto.getDepartmentCode()
    );
    return department;
    }

    public DepartmentDto getDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
