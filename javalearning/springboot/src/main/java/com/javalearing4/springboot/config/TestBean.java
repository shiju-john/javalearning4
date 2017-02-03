package com.javalearing4.springboot.config;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
public class TestBean {
	
	@Autowired
	private ConfigurationBean configurationBean;
	
	@PreDestroy
	public void destroy(){
		System.out.println( "Destroy");
	}

	/**
	 * @return the configurationBean
	 */
	public ConfigurationBean getConfigurationBean() {
		return configurationBean;
	}

	/**
	 * @param configurationBean the configurationBean to set
	 */
	public void setConfigurationBean(ConfigurationBean configurationBean) {
		this.configurationBean = configurationBean;
	}
	
	

}
