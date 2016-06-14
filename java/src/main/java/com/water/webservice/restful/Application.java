package com.water.webservice.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("security.basic.enabled", "false");
		SpringApplication.run(Application.class, args);
	}
}
