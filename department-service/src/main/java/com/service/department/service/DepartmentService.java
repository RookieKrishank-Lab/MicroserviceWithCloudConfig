package com.service.department.service;

import com.service.department.dto.DepartmentDto;
import com.service.department.entity.Department;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
