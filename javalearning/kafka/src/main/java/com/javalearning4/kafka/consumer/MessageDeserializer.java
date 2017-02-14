package com.javalearning4.kafka.consumer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;
import com.javalearning4.kafka.message.Message;
import com.javalearning4.kafka.message.MessageImpl;

public class MessageDeserializer implements Deserializer<Message<String>>{

	
	
	
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		// TODO Auto-generated method stub		
	}

	public Message<String> deserialize(String topic, byte[] data) {
		String inputData = new String(data);
		Gson gson = new Gson();
		Message<String> message = gson.fromJson(inputData,MessageImpl.class );
		return message;
	}

}
