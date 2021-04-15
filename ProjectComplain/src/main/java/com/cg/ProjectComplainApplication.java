package com.cg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectComplainApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectComplainApplication.class);
	public static void main(String[] args) {
		logger.info("Staring the TomcatContainer....!!!");
		SpringApplication.run(ProjectComplainApplication.class, args);
	}

}
