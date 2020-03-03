package com.generali.legalcasemanagement.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler2 {

    private Logger LOG = LoggerFactory.getLogger(Scheduler2.class);

    @Scheduled(fixedRate = 8000)
    public void runSchedule() {
        LOG.info(this.getClass().getName());
    }
}
