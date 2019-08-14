package com.oogzy.spring.boot.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ArtemisProducerTemplate {
    @Autowired
    JmsTemplate template;

    @Bean
    CommandLineRunner start () {
        return args -> {
            template.convertAndSend( "myQueue" , "Hello World!" );
        };
    }
}