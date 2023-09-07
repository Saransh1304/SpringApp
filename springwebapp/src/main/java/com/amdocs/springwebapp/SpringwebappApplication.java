package com.amdocs.springwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebappApplication.class, args);
	
	}
	
	@Bean("rt")
	public RestTemplate getRestTemplate()
	{
		RestTemplate rt=new RestTemplate();
		return rt;
	}

}
