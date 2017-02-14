package com.javalearning4.kafka.consumer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.javalearning4.kafka.message.Message;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
public class ConsumerRunner {
	
	@Autowired
	Consumer<Message<String>> consumer ; 
	
	@PostConstruct
	public void consumerRunner(){
		consumer.consumes(null);
	}
	

}
