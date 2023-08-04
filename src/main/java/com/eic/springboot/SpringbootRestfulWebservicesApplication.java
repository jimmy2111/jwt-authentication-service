package com.eic.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eic.springboot.entity.User;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "Spring Boot REST API",
				description="Spring Boot REST API Documentation",
				version="v1.0",
				contact= @Contact(
						name="Jimmy",
						email="jimmy@gmail.com"
				),
				license = @License(
						name="Apache 2.0"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation",
				url="")
)
public class SpringbootRestfulWebservicesApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
