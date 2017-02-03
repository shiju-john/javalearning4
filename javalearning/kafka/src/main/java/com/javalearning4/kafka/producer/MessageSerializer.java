package com.javalearning4.kafka.producer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.javalearning4.kafka.message.Message;


/**
 * 
 * @author shiju.john
 *
 */
public class MessageSerializer implements Serializer<Message<String>>{

	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	public byte[] serialize(String topic, Message<String> data) {
		return null!=data ?data.getJsonString().getBytes():null;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

}
