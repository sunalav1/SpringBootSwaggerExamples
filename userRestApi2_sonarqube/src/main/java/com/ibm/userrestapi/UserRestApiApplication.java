package com.ibm.userrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserRestApiApplication {
	
	private UserRestApiApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(UserRestApiApplication.class, args);
	}
}
