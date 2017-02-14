package com.javalearning4.kafka.message;

import com.google.gson.Gson;
/**
 * 
 * @author shiju.john
 *
 */
public class MessageImpl implements Message<String>{

	/**
	 * 
	 */
	private String messageKey;
	private String data;
	
	
	private static final long serialVersionUID = 1L;

	public String getMessageKey() {
		return messageKey;
	}

	public String getJsonString() {
		Gson gson = new Gson();
		String jsonData = gson.toJson(this);
		return jsonData;
	}

	public Message<String> convertToMessageObject(String jsonString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, MessageImpl.class);
	}

	/**
	 * @param messageKey the messageKey to set
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {		
		return getJsonString();
	}

}
