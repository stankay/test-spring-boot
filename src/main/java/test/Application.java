package test;

import java.util.Properties;

import org.apache.catalina.filters.RemoteAddrFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
@EnableScheduling
@EnableAsync
public class Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${ip.addresses}")
    public String ipAddresses;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/static/**"
                )
                .addResourceLocations("classpath:/static/");
    }

    @ConfigurationProperties
    @Bean("springProperties")
    public Properties getSpringProperties() {
        return new Properties();
    }

    /********************* REMOTE ADDR FILTERING PART BEGIN ********************/

    private FilterRegistrationBean<RemoteAddrFilter> createFilterRegistration(String ipAddress) {
        FilterRegistrationBean<RemoteAddrFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        RemoteAddrFilter filter = new RemoteAddrFilter();
        filter.setAllow(ipAddress);
        filter.setDenyStatus(403);
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /**
     * This will work
     */
    @Bean
    public FilterRegistrationBean<RemoteAddrFilter> primaryAddressFilter() {
        return createFilterRegistration(ipAddresses);
    }

    /**
     * This will NOT work
     */
    @Bean
    public FilterRegistrationBean<RemoteAddrFilter> primaryBddressFilter() {
        return createFilterRegistration("127.0.0.1");
    }
}