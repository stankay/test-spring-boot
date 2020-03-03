package com.generali.legalcasemanagement.camunda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler1 {

    private Logger LOG = LoggerFactory.getLogger(Scheduler1.class);

    @Scheduled(fixedRate = 7000)
    public void runSchedule() {
        LOG.info(this.getClass().getName());
    }
}
