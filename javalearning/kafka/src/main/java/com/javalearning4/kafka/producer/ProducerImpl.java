package com.javalearning4.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.javalearning4.kafka.message.Message;
/**
 * 
 * @author shiju.john
 *
 */
@EnableConfigurationProperties
public class ProducerImpl implements Producer<Message<String>>{
	
	
	private static final long serialVersionUID = 1L;
	
	@Value("${kafka.topicName}")
	String topicName;
	
	@Value("${kafka.serverurl}")
	String serverurl;
	
	private Map<String,String> producerProperties ;
	
	private org.apache.kafka.clients.producer.Producer<String, Message<String>> messageProducer;
	
	
	
	@PostConstruct
	public void initProperties(){
		producerProperties = new HashMap<String, String>();
		producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverurl);
		producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,MessageSerializer.class.getName());
		messageProducer = new KafkaProducer(producerProperties);
	}
	
	
	
	public void send(Message<String> message) { 		
		ProducerRecord<String, Message<String>> producerRecord =
				new ProducerRecord<String, Message<String>>(topicName,message);
		messageProducer.send(producerRecord);
	}
	
	@PreDestroy
	public void destroy(){		
		messageProducer.close();
	}
	
	



}
