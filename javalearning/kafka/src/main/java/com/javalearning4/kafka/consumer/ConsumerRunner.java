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
		getConsumer().consumes(null);
	}

	/**
	 * @return the consumerbean
	 *//*
	public Consumer<Message<String>> getConsumerbean() {
		return consumerbean;
	}

	*//**
	 * @param consumerbean the consumerbean to set
	 *//*
	public void setConsumerbean(Consumer<Message<String>> consumerbean) {
		this.consumerbean = consumerbean;
	}*/

	/**
	 * @return the consumer
	 */
	public Consumer<Message<String>> getConsumer() {
		return consumer;
	}

	/**
	 * @param consumer the consumer to set
	 */
	public void setConsumer(Consumer<Message<String>> consumer) {
		this.consumer = consumer;
	}
	

}
