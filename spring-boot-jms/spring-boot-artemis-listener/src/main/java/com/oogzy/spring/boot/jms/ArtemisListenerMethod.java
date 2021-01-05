package com.oogzy.spring.boot.jms;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ArtemisListenerMethod implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArtemisListenerMethod.class);

	/**
	 * Broker URL configuration at application.yml file </br>
	 * </br>
	 * More configurations:</br>
	 * {@link https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html}
	 */
	@Override
	public void onMessage(Message message) {
		try {
			LOGGER.info("Message {} received", message.getJMSMessageID());
			if (message instanceof TextMessage) {
				LOGGER.info("Message text: {}", ((TextMessage) message).getText());
			}
			else if (message instanceof BytesMessage) {
				BytesMessage bytesMessage = (BytesMessage) message;
				byte[] data = new byte[(int) bytesMessage.getBodyLength()];
				bytesMessage.readBytes(data);
				// Implementation ...
			}
			else {
				throw new RuntimeException("Message type not implemented");
			}
		}
		catch (JMSException e) {
			LOGGER.warn("JMS API exception", e);
		}
	}

}