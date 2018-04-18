package com.archibald.archibald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.archibald.service.impl")
@ComponentScan("com.archibald.controller")
@ComponentScan("com.archibald.security")
@SpringBootApplication
@EnableAutoConfiguration
public class ArchibaldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchibaldApplication.class, args);
	}
}
