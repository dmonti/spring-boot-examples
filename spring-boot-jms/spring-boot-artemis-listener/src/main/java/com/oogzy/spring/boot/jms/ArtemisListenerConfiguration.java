package com.oogzy.spring.boot.jms;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class ArtemisListenerConfiguration {

	@Autowired
	ConnectionFactory connectionFactory;

	@Autowired
	ArtemisListenerMethod listener;

	@Bean
	public DefaultMessageListenerContainer messageListener() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setDestinationName("myQueue");
		container.setMessageListener(listener);
		return container;
	}

}