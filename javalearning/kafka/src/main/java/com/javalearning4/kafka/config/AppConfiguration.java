package com.javalearning4.kafka.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.javalearning4.kafka.consumer.Consumer;
import com.javalearning4.kafka.consumer.ConsumerImpl;
import com.javalearning4.kafka.message.Message;
import com.javalearning4.kafka.message.MessageProcessor;
import com.javalearning4.kafka.producer.Producer;
import com.javalearning4.kafka.producer.ProducerImpl;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
@EnableConfigurationProperties
public class AppConfiguration {


	@Bean
	public Consumer<Message<String>> consumer (){
		Consumer<Message<String>> producer = new ConsumerImpl();
		return producer;
	}
	
	@Bean
	public Producer<Message<String>> producer(){
		Producer<Message<String>> producer = new ProducerImpl();
		return producer;
	}
	
	@Bean
	public MessageProcessor<Message<String>> processor(){		 
		return  new MessageProcessor<Message<String>>();
	}
	
	public AppConfiguration() {
		System.out.println();
	}	
	
}
