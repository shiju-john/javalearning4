package com.javalearning4.kafka.message;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.javalearning4.kafka.producer.Producer;


@Configuration
public class Processor {
	
	
	@Autowired
	Producer<Message<String>> producer ;
	
	
	@PostConstruct
	public void init(){
		execute();
	}

	private void execute() {
		MessageImpl  impl = new MessageImpl();
		impl.setMessageKey("1");
		impl.setData("Test_Shiju");
		producer.send(impl);
		
	}

}
