package test;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartStopBean {

    @Autowired
    @Qualifier("springProperties")
    private Properties springProperties;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(">>> App starts");

        /*
        //print all spring props
        System.out.println("--------------");
        new TreeMap<>(springProperties)
        .entrySet()
        .forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
        System.out.println("--------------");
        */
    }

    @EventListener
    public void onContextClosedEvent(ContextClosedEvent event) {
        System.out.println(">>> App stops");
    }
}
