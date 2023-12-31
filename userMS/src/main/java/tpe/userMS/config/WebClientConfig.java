package tpe.userMS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
@ComponentScan("tpe.userMS")
public class WebClientConfig {

    @Bean("userRest")
    WebClient userRestWebClient() {
        return WebClient.create();
    }

}
