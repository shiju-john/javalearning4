package com.javalearning4.kafka.consumer;

import com.javalearning4.kafka.message.Message;
/**
 * 
 * @author shiju.john
 *
 */
public interface CallBack {
	
	public void consumedMessage(Message<String> message);

}
