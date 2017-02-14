package com.javalearning4.kafka.producer;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author shiju.john
 *
 * @param <T>
 */
@Configuration
public interface Producer<T> extends Serializable{
	
	/**
	 * 
	 * @param message
	 */
	public void send(T message);

}
