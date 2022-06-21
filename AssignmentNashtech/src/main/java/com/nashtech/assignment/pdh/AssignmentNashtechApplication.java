package com.nashtech.assignment.pdh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AssignmentNashtechApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentNashtechApplication.class, args);
	}

}
