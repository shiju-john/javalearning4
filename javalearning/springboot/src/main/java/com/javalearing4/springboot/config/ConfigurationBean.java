package com.javalearing4.springboot.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
public class ConfigurationBean {
	
	@PostConstruct
	public void postConstaructMethod(){
		System.out.println("Post Construct Method");
	}
	
	

}
