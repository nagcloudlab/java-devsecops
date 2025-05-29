package org.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        name = "npci.location",
        havingValue = "hyderabad"
)
public class NPCIAutoConfiguration {

    @Bean
    public String bean1() {
        return "BEAN-1";
    }

}
