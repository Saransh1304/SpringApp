package com.amdocs.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringrestApplication {

	public static void main(String[] args) {
		System.out.println("Rest API");
		SpringApplication.run(SpringrestApplication.class, args);
	}

}
