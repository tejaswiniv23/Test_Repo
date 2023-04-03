package com.springbootrest.restDemo;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(RestDemoApplication.class);
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		logger.info("Running Spring boot application");
		SpringApplication.run(RestDemoApplication.class, args);
		
	}

}
