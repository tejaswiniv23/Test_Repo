package com.springbootrest.restDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(RestDemoApplication.class);

	public static void main(String[] args) {
		//System.out.println("Running springboot application...");
		logger.info("Running Spring boot application");
		SpringApplication.run(RestDemoApplication.class, args);
		
	}

}
