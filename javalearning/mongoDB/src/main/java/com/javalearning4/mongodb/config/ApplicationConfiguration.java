package com.javalearning4.mongodb.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
@EnableConfigurationProperties
public class ApplicationConfiguration {
	
	
	
	@Bean
	public MongoDBJavaClient getMongoDbClient(){
		return new MongoDBJavaClient();
	}
	

}
