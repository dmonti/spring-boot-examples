package com.oogzy.spring.boot.jms;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@SpringBootTest
public class SpringJmsProducerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger( SpringJmsProducerTest.class );

    CountDownLatch latch = new CountDownLatch( 1 );

    public ActiveMQConnectionFactory activeMQConnectionFactory () {
        return new ActiveMQConnectionFactory( "tcp://localhost:61616" );
    }

    public CachingConnectionFactory cachingConnectionFactory () {
        return new CachingConnectionFactory( activeMQConnectionFactory() );
    }

    public JmsTemplate jmsTemplate () {
        return new JmsTemplate( cachingConnectionFactory() );
    }

    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory () {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory( activeMQConnectionFactory() );
        factory.setConcurrency( "1-1" );
        return factory;
    }

    @JmsListener ( destination = "myQueue" )
    public void receive ( String message ) {
        LOGGER.info( "Message received: {}" , message );
        latch.countDown();
    }

    @Test
    public void testSend () throws Exception {
        jmsTemplate().convertAndSend( "myQueue" , "Hello World!" );

        latch.await( 1 , TimeUnit.SECONDS );
        assertEquals( 0 , latch.getCount() );
    }
}