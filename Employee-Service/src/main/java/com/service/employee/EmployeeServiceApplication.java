package com.service.employee;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee REST API Documentations",
				description = "Add Employee and Fetch Employee by ID",
				version = "1.0v"
		)
)
@SpringBootApplication
@EnableFeignClients									// Enable component scanning for interfaces that declare itself as feign client
//@EnableEurekaClient
public class EmployeeServiceApplication {
	/*@Bean
	public WebClient webClient(){
		return WebClient.builder().build();					// build method to build an instance of webclient
	}*/

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
