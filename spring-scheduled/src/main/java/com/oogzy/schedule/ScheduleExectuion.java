package com.oogzy.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleExectuion {
    private static final Logger LOGGER = LoggerFactory.getLogger( ScheduleExectuion.class );

    private static final int TEN_SECONDS = 10 * 1000;

    @Scheduled ( fixedDelay = TEN_SECONDS )
    public void execute () {
        LOGGER.info( "Job executed!" );
    }
}