package bare;

import java.util.Properties;

import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartStopBean {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(">>> App starts");
    }

    @EventListener
    public void onContextClosedEvent(ContextClosedEvent event) {
        System.out.println(">>> App stops");
    }
}
