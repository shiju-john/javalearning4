package com.javalearning4.mongodb.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
public class MongoDBJavaClient {
	
	@Value("${mongodb.server}")
	private String moongodbServer;
	
	@Value("${mongodb.port}")
	private int moongodbPort;
	
	@Value("${mongodb.dbs}")
	private String connectedDb;
	
	@Value("${mongodb.user}")
	private String user;
	
	@Value("${mongodb.password}")
	private String password;
	
	private final MongoClient mongoClient ; 
	
	private MongoDatabase database ;
	
	
	public MongoDBJavaClient(){			
		MongoCredential credential = MongoCredential.createMongoCRCredential(user,connectedDb,password.toCharArray());
		ServerAddress address = new ServerAddress(moongodbServer, moongodbPort);		
		mongoClient = new MongoClient(Arrays.asList(address),Arrays.asList(credential));		
	}
	
	@PostConstruct
	public void postConstruct(){
		database = mongoClient.getDatabase(connectedDb);
	}
	
	public void getCollection(String collectionName) {
		database.getCollection(collectionName);
	}

}
