package com.service.employee.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDto {

    private Long departmentId;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}
