package bare.camel;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CamelRouteBuilder extends RouteBuilder {

    @Autowired
    ProducerTemplate producerTemplate;

    @Value("${cron.expression}")
    String cronExpression;

    private static final String DIRECT_FOO = "direct:foo";

    @Override
    public void configure() throws Exception {
        from(DIRECT_FOO)
        .id(DIRECT_FOO)
        .log(body().toString())
        ;

        if (!cronExpression.trim().equals("-")) {
            from("quartz://stankayTimer?cron=" + cronExpression)
                    .id("quartzTimerRoute")
                    .log("ahoj");
        }
    }

    @EventListener
    public void handleContextStart(@SuppressWarnings("unused") ApplicationReadyEvent applicationReadyEvent) {
        producerTemplate.sendBody(DIRECT_FOO, "hello");
    }
}
