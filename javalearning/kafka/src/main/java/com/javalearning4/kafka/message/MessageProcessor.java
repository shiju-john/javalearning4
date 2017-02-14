package com.javalearning4.kafka.message;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.javalearning4.kafka.producer.Producer;
@Configuration
public class MessageProcessor<T> {
	
	@Autowired
	Producer<Message<String>> producer;
	
	@PostConstruct
	public void insertMessage(){
		MessageImpl  message =null;
		for(int i=0;i<10;i++){
			message = new MessageImpl();
			message.setData(""+i);
			message.setMessageKey(""+i);
			producer.send(message);
		}
		
		
	}

}
