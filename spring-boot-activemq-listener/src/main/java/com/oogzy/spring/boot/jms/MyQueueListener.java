package com.oogzy.spring.boot.jms;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyQueueListener {
    private static final Logger LOGGER = LoggerFactory.getLogger( MyQueueListener.class );

    /**
     * Configure the broker URL at application.yml
     * 
     * More configurations:
     * https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
     */
    @JmsListener ( destination = "myQueue" )
    public void receive ( Message message ) throws JMSException {
        LOGGER.info( "Message {} received" , message.getJMSMessageID() );

        if ( message instanceof TextMessage ) {
            LOGGER.info( "Message text: {}" , ( ( TextMessage ) message ).getText() );
        } else if ( message instanceof BytesMessage ) {
            BytesMessage bytesMessage = ( BytesMessage ) message;
            byte[] data = new byte[ ( int ) bytesMessage.getBodyLength() ];
            bytesMessage.readBytes( data );
            // Implementation ...
        } else {
            throw new RuntimeException( "Message type not implemented" );
        }
    }
}