package com.oogzy.spring.boot.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMethod {
    private static final Logger LOGGER = LoggerFactory.getLogger( ScheduleMethod.class );

    private static final int TEN_SECONDS = 10 * 1000;

    /**
     * The @Scheduled documentation can be found at:
     * https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling-annotation-support-scheduled
     */
    @Scheduled ( fixedDelay = TEN_SECONDS )
    public void execute () {
        LOGGER.info( "Job executed!" );
    }
}