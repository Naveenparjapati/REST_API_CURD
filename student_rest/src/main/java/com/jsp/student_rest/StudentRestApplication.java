package com.jsp.student_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student REST API",description = "rest api for crud operations on student details",contact = @Contact(email = "naveenkumarp1009@gmail.com",name = "Navven N")))
public class StudentRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRestApplication.class, args);
	}

}
