package com.service.department.service.impl;

import com.service.department.dto.DepartmentDto;
import com.service.department.entity.Department;
import com.service.department.mappper.DepartmentMapper;
import com.service.department.repository.DepartmentRepository;
import com.service.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private DepartmentMapper departmentMapper;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        /*Department department = new Department(
                departmentDto.getDepartmentId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );*/

        Department department = departmentMapper.getDepartment(departmentDto);

        Department saveDepartment = departmentRepository.save(department);

        /*
        DepartmentDto savedDepartmentDto = new DepartmentDto(
                saveDepartment.getDepartmentId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode()
        );*/

        DepartmentDto savedDepartmentDto = departmentMapper.getDepartmentDto(saveDepartment);

        return savedDepartmentDto;
    }

    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = departmentMapper.getDepartmentDto(department);
        return departmentDto;
    }
}
