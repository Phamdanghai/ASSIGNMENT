package com.nashtech.assignment.pdh;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//(exclude = { SecurityAutoConfiguration.class })
@EnableWebSecurity
public class AssignmentNashtechApplication {
	
//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}

	public static void main(String[] args) {
		SpringApplication.run(AssignmentNashtechApplication.class, args);
	}

}
