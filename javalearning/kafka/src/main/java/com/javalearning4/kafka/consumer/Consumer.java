package com.javalearning4.kafka.consumer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.javalearning4.kafka.message.Message;



public abstract class Consumer<T> implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KafkaConsumer<String,String> kafkaConsumer;
	
	private String topicName;
	private String groupId;
	private Message<String> message;
	
	/**
	 * 
	 * @param topicName
	 * @param groupId
	 */
	protected void postConstract(String topicName,Properties properties,Message<String> message){
		this.topicName = topicName ;
		this.message = message;
		kafkaConsumer = new KafkaConsumer<String, String>(properties);
		kafkaConsumer.subscribe(Arrays.asList(topicName));
		ConsumerRecords<String, String>  records = kafkaConsumer.poll(100);
		 for (ConsumerRecord<String, String> record : records){
             System.out.println(record.value());
		}
		
	}
	
	@PostConstruct
	public abstract  void postConstruct ();
	
	public abstract  Message<String> consumes(Message<String> message);

}
