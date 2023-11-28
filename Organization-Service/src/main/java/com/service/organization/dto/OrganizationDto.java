package com.service.organization.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Schema(
        description = "Organization model info"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    private Long organizationId;
    @Schema(description = "Organization Name")
    private String organizationName;
    @Schema(description = "Organization Description")
    private String organizationDescription;
    @Schema(description = "Organization Description")
    private String organizationCode;
    @Schema(description = "Organization created date")
    private LocalDateTime createdDate;
}
