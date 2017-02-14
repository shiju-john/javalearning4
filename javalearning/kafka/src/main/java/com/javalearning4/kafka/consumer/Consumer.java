package com.javalearning4.kafka.consumer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.javalearning4.kafka.message.Message;


/**
 * 
 * @author shiju.john
 *
 * @param <T>
 */
public abstract class Consumer<T> implements Serializable,Runnable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KafkaConsumer<String,Message<String>> kafkaConsumer;
	
	private String topicName;
	private String groupId;
	
	
	private CallBack callBack;
	
	/**
	 * 
	 * @param topicName
	 * @param groupId
	 */
	protected void postConstract(String topicName,Properties properties){
		this.setTopicName(topicName) ;
		kafkaConsumer = new KafkaConsumer<String, Message<String>>(properties);
		kafkaConsumer.subscribe(Arrays.asList(topicName));		
	}
	
	@PostConstruct
	public abstract  void postConstruct ();
	
	public abstract  void consumes(CallBack callBack);

	public void run() {
		
		while(true){
			ConsumerRecords<String, Message<String>>  records = kafkaConsumer.poll(100);
			 for (ConsumerRecord<String, Message<String>> record : records){
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

	/**
	 * @return the topicName
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * @param topicName the topicName to set
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
