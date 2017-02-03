package com.javalearning4.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author shiju.john
 *
 */
@SpringBootApplication
@ComponentScan("com.javalearing4.springboot.config")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
