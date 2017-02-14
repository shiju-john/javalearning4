package com.javalearning4.kafka.consumer;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.javalearning4.kafka.message.Message;



@Configuration
public class ConsumerImpl extends Consumer<Message<String>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Value("${kafka.topicName}")
	String topicName;
	
	@Value("${kafka.serverurl}")
	String serverurl;
	
	@Value("${kafka.consumer.groupId}")
	String groupId;
	
	@Value("${kafka.consumer.messageImpl}")
	String messageClass;
	
	public void consumes(CallBack callBack) {
		this.setCallBack(callBack);
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	@PostConstruct
	public void postConstruct() {	
		 Properties configProperties = new Properties();
         configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverurl);
         configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
         configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MessageDeserializer.class.getName());
         configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
         configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");
         
		try {
			super.postConstract(topicName, configProperties,(Message<String>)Class.forName(messageClass).newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
