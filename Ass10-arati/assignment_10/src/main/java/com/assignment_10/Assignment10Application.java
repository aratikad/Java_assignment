package com.assignment_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.assignment_10.config","com.assignment_10.service", "com.assignment_10.repositries", "com.assignment_10.controller","com.assignment_10.model","com.assignment_10.exceptions"})
@EnableJpaRepositories(basePackages = { "com.assignment_10.repositries" })
@SpringBootApplication
public class Assignment10Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment10Application.class, args);
	}

}
