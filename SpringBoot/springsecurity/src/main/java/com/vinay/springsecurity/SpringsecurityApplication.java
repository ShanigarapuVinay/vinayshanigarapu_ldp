package com.vinay.springsecurity;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		// Set environment variables in the system properties
		System.setProperty("MY_APP_USERNAME", dotenv.get("MY_APP_USERNAME"));
		System.setProperty("MY_APP_PASSWORD", dotenv.get("MY_APP_PASSWORD"));
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		SpringApplication.run(SpringsecurityApplication.class, args);
	}

}
