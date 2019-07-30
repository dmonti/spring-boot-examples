package com.oogzy.spring.boot.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtemisListenerApplication {
    public static void main ( String[] args ) {
        SpringApplication.run( ArtemisListenerApplication.class , args );
    }
}