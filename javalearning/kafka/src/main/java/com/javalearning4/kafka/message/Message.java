package com.javalearning4.kafka.message;

import java.io.Serializable;
/**
 * 
 * @author shiju.john
 *
 */
public interface Message<T> extends Serializable {
	/**
	 * 
	 * @return
	 */
	public T getMessageKey();
	
	/**
	 * 
	 * @return
	 */
	public String getJsonString();
	
	
	/**
	 * 
	 * @param jsonString
	 * @return
	 */
	public Message<T> convertToMessageObject(String jsonString);

}
