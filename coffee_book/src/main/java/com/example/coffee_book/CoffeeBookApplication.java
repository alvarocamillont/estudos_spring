package com.example.coffee_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CoffeeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeBookApplication.class, args);
	}

}
