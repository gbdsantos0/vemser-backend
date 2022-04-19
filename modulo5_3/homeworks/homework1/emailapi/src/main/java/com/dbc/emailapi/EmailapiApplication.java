package com.dbc.emailapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailapiApplication.class, args);
	}

}
