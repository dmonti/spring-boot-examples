package com.oogzy.spring.boot.jms;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtemisBrokerConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArtemisBrokerConfiguration.class);

	@Autowired
	private ArtemisProperties artemisProperties;

	@Bean
	public ArtemisConfigurationCustomizer customizer() {
		return new ArtemisConfigurationCustomizer() {
			String brokerUrl = Stream.of("tcp://localhost:", String.valueOf(artemisProperties.getPort())) //
					.collect(Collectors.joining());

			@Override
			public void customize(org.apache.activemq.artemis.core.config.Configuration configuration) {
				try {
					LOGGER.info("Adding netty acceptor for: {}", brokerUrl);
					configuration.addAcceptorConfiguration("netty", brokerUrl);
				}
				catch (Exception e) {
					throw new RuntimeException("Failed to add netty acceptor", e);
				}
			}
		};
	}

}