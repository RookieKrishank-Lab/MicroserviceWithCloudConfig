package com.service.organization.controller;

import com.service.organization.dto.OrganizationDto;
import com.service.organization.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Controller Service",
        description = "Using the following request user can Add Organization and Fetch Organization by ID"
)

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    @Operation(
            summary = "Add new Organization",
            description = "Using this you can add new org."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/createOrganization")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrganization);
    }

    @Operation(
            summary = "Find organization by there org code",
            description = "Using this you can find particular org."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("getOrganization/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.status(HttpStatus.OK).body(organizationDto);
    }

}