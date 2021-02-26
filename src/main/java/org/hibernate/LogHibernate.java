package org.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LogHibernate {
    private static final Logger LOG = LoggerFactory.getLogger(LogHibernate.class);

    @Scheduled(cron = "*/5 * * * * ?")
    public void generate() {
        LOG.info("hello");
    }
}
