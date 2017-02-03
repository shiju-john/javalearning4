package com.javalearning4.kafka.message;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@ComponentScan("com.javalearning4.kafka")
@SpringBootTest
@RunWith(SpringRunner.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	/*SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
	builder.build();
   	//builder.profiles("kafka").build();
   	 builder.application().run( args);*/
	}
}
