package com.epam.denisov.testwebproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:spring_mvc_config.xml")
@SpringBootApplication
public class TestWebProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestWebProjectApplication.class, args);
	}
}
