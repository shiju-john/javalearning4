package com.javalearning4.mongodb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author shiju.john
 *
 */
@SpringBootApplication
@ComponentScan("com.javalearning4.mongodb.config")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
