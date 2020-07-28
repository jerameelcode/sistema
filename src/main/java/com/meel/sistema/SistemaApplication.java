package com.meel.sistema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SistemaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
		
		LOGGER.error("MESSAGE LOG from bootstraping class");
		LOGGER.warn("MESSAGE LOG from bootstraping class");
		LOGGER.info("MESSAGE LOG from bootstraping class");
		LOGGER.trace("MESSAGE LOG from bootstraping class");
		
	}

}
