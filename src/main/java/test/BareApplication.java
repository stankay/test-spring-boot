package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"test", "org.hibernate"})
@EnableScheduling
public class BareApplication {
    public static void main(String[] args) {
        SpringApplication.run(BareApplication.class, args);
    }
}
