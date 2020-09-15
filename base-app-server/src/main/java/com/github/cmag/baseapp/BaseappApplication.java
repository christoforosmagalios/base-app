package com.github.cmag.baseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BaseappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseappApplication.class, args);
	}

}
