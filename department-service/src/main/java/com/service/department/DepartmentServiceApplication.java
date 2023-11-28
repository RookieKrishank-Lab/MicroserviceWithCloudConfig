package com.service.department;

import com.service.department.mappper.DepartmentMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Department REST API Documentations",
				description = "Add Department and Fetch Department by ID",
				version = "1.0v"
		)
)
@SpringBootApplication
//@EnableEurekaClient
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	@Bean
	public DepartmentMapper mapper(){
		return new DepartmentMapper();
	}

}
