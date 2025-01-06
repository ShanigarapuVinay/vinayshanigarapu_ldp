package com.vinay.spring_boot_external;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExternalApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		System.setProperty("MYSQL_USERNAME", dotenv.get("MYSQL_USERNAME"));
		System.setProperty("MYSQL_PASSWORD", dotenv.get("MYSQL_PASSWORD"));
		SpringApplication.run(SpringBootExternalApplication.class, args);
	}

}
