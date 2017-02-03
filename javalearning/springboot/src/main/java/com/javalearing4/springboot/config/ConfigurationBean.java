package com.javalearing4.springboot.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
@EnableConfigurationProperties
public class ConfigurationBean {
	
	@Value("${server.value}")
	public String serverValue;
	
	
	@PostConstruct
	public void postConstaructMethod(){
		System.out.println("Post Construct Method");
	}
	
	@PreDestroy
	public void presdetroy(){
		System.out.println("Config value "+serverValue+" destroy method");
	}
	

}
