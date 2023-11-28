package com.service.employee.service;

import com.service.employee.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationService {

    @GetMapping("api/v1/organizations/getOrganization/{organizationCode}")
    public OrganizationDto getOrganization(@PathVariable String organizationCode);

}
