package com.nashtech.assignment.pdh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//(exclude = { SecurityAutoConfiguration.class })
@EnableWebSecurity
public class AssignmentNashtechApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentNashtechApplication.class, args);
	}

}
