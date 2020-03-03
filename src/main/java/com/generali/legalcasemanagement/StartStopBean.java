package com.generali.legalcasemanagement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartStopBean implements ApplicationListener<ApplicationContextEvent> {

    @Value("${myvalue}")
    String myvalue;

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            System.out.println(">>> ContextRefreshedEvent - " + myvalue);
        } else if (event instanceof ContextClosedEvent) {
            System.out.println(">>> ContextClosedEvent");
        }
    }
}
