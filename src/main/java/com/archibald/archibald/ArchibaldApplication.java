package com.archibald.archibald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.archibald.service.impl")
@SpringBootApplication
public class ArchibaldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchibaldApplication.class, args);
	}
}
