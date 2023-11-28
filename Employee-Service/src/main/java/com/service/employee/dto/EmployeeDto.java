package com.service.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "EmployeeDto model info"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    @Schema(description = "Employee First Name")
    private String firstName;
    @Schema(description = "Employee Last Name")
    private String lastName;
    @Schema(description = "Employee Email")
    private String email;
    @Schema(description = "Employee Dept code")
    private String departmentCode;
    @Schema(description = "Employee Org code")
    private String organizationCode;
}
