package com.javalearning4.kafka.consumer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.javalearning4.kafka.message.Message;



public abstract class Consumer<T> implements Serializable,Runnable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KafkaConsumer<String,Message> kafkaConsumer;
	
	private String topicName;
	private String groupId;
	private Message<String> message;
	
	private CallBack callBack;
	
	/**
	 * 
	 * @param topicName
	 * @param groupId
	 */
	protected void postConstract(String topicName,Properties properties,Message<String> message){
		this.topicName = topicName ;
		this.message = message;
		kafkaConsumer = new KafkaConsumer<String, Message>(properties);
		kafkaConsumer.subscribe(Arrays.asList(topicName));		
	}
	
	@PostConstruct
	public abstract  void postConstruct ();
	
	public abstract  void consumes(CallBack callBack);

	public void run() {
		
		while(true){
			ConsumerRecords<String, Message>  records = kafkaConsumer.poll(100);
			 for (ConsumerRecord<String, Message> record : records){
	           System.out.println(record.value());
	           if(null!=callBack){
	        	   callBack.consumedMessage(record.value());
	           }
			}
		}
		
	}

	/**
	 * @return the callBack
	 */
	public CallBack getCallBack() {
		return callBack;
	}

	/**
	 * @param callBack the callBack to set
	 */
	public void setCallBack(CallBack callBack) {
		this.callBack = callBack;
	}

}
