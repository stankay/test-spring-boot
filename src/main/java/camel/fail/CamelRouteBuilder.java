package camel.fail;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CamelRouteBuilder extends RouteBuilder {

    @Autowired
    ProducerTemplate producerTemplate;

    private static final String DIRECT_FOO = "direct:foo";

    @Override
    public void configure() throws Exception {
        from(DIRECT_FOO)
        .id(DIRECT_FOO)
        .log(body().toString())
        ;
    }

    @EventListener
    public void handleContextStart(@SuppressWarnings("unused") ApplicationReadyEvent applicationReadyEvent) {
        producerTemplate.sendBody(DIRECT_FOO, "hello");
    }
}
